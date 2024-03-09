package com.interview.arcesium.learning;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        try {
            List<ExpressionEvaluator.ExpressionGroup> expressionGroups = ExpressionEvaluator.getGroupOfExpressions();
            processExpressionGroups(expressionGroups);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // printResult();
    }

    private static List<String> processExpressionGroups(List<ExpressionEvaluator.ExpressionGroup> expressionGroups) {

        List<String> answer = new ArrayList<>();
        for (ExpressionGroup expressionGroup : expressionGroups) {
            String expression = processExpressionGroup(expressionGroup);
            answer.add(expression);
        }


        System.out.println(Arrays.toString(answer.toArray()));
        return answer;
    }

    private static String processExpressionGroup(ExpressionEvaluator.ExpressionGroup expressionGroup){
        Map<String, String> nameToValue = new HashMap<>();
        System.out.println();
        System.out.println();
        System.out.println(expressionGroup);

        Queue<Expression> q
                = new LinkedList<>();

        // Build Dependency Graph and get ready for evaluation using topo sort

        // adj Map
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, Expression> expressionMap = new HashMap<>();
        for (Expression expression :
                expressionGroup.expressions) {
            // evaluate direct expression
            if (expression.getExpressionType().equals("DIRECT")) {
                // nameToValue.put(expression.getName(), expression.getExpression());
                q.add(expression);
            } else {
                for (String dependency :
                        expression.dependencies) {
                    if(graph.containsKey(dependency)){
                        List<String> adjList = graph.get(dependency);
                        adjList.add(expression.getName());
                        graph.put(dependency, adjList);
                    } else {
                        List<String> adjList = new ArrayList<>();
                        adjList.add(expression.getName());
                        graph.put(dependency, adjList);
                    }
                    if(!graph.containsKey(expression.getName())){
                        graph.put(expression.getName(), new ArrayList<>());
                    }

                }
            }

            indegree.put(expression.getName(), expression.getDependencies().size());
            expressionMap.put(expression.getName(), expression);

        }
        System.out.println("Graph ");
        graph.forEach((key, value) -> System.out.println(key + " " + value));


        while(!q.isEmpty()){

            Expression expression = q.poll();
            if (expression.getExpressionType().equals("DIRECT")){
                nameToValue.put(expression.getName(), expression.getExpression());
            } else {
                String expression1 = expression.getExpression();
                for (String dependency :
                        expression.dependencies){
                    String variableName = "${"+dependency+"}";
                    expression1 = expression1.replace(variableName, nameToValue.get(dependency));
                }

                // do the dollar / RS formatting right here

                System.out.println(expression1);
                expression1 = ExpressionEvaluator.formatExpression(expression, expression1);
                System.out.println(expression1);
                nameToValue.put(expression.getName(), expression1);
            }

            for (String adjNode : graph.get(expression.getName())) {
                int indgreeOfAdjNode = indegree.get(adjNode);
                indgreeOfAdjNode = indgreeOfAdjNode -1;
                indegree.put(adjNode, indgreeOfAdjNode);
                if(indgreeOfAdjNode == 0){
                    q.add(expressionMap.get(adjNode));
                }
            }
            nameToValue.forEach((key, value) -> System.out.println(key + " " + value));
        }

        nameToValue.forEach((key, value) -> System.out.println(key + " " + value));

        // format result
        StringBuilder formattedString = new StringBuilder();
        formattedString.append(expressionGroup.getGroupName());
        formattedString.append(":");
        for (Expression expression :
                expressionGroup.expressions) {

            /*if(expression.expressionType.equals("DIRECT")) {
                formattedString = formattedString.append(expression.getName()).append(":").append(nameToValue.get(expression.getName()));
            } else if (Objects.equals(expression.getExpressionType(), "DOLLAR_EXPRESSION")) {
                formattedString = formattedString.append(expression.getName()).append(":(").append(nameToValue.get(expression.getName())).append(")").append(" $");
            } else if(Objects.equals(expression.getExpressionType(), "RS_EXPRESSION")){
                formattedString = formattedString.append(expression.getName()).append(":(").append(nameToValue.get(expression.getName())).append(")").append(" RS");
            }*/
            formattedString.append(expression.getName()).append(":").append(nameToValue.get(expression.getName())).append(":");
        }

        return formattedString.substring(0, formattedString.length()-1);
    }

    private static String formatExpression(Expression expression, String expressionValue){
        StringBuilder formattedString = new StringBuilder();

        if (Objects.equals(expression.getExpressionType(), "DOLLAR_EXPRESSION")) {
            formattedString.append("(").append(expressionValue).append(")").append(" $");
        } else if(Objects.equals(expression.getExpressionType(), "RS_EXPRESSION")){
            formattedString.append("(").append(expressionValue).append(")").append(" RS");
        }
        return formattedString.toString();

    }

    private static List<ExpressionEvaluator.ExpressionGroup> getGroupOfExpressions() throws IOException {
         // Test Cases - 1. https://raw.githubusercontent.com/arcjsonapi/expressionDataService/main/test1
        // 2. https://raw.githubusercontent.com/arcjsonapi/expressionDataService/main/expressions
        URL obj = new URL("https://raw.githubusercontent.com/arcjsonapi/expressionDataService/main/expressions");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response);
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            Type listType = new TypeToken<ArrayList<ExpressionGroup>>(){}.getType();
            List<ExpressionEvaluator.ExpressionGroup> expressionGroups = gson.fromJson(response.toString(), listType);

            ExpressionEvaluator.ExpressionGroup[] mcArray = gson.fromJson(response.toString(), ExpressionEvaluator.ExpressionGroup[].class);
            System.out.println(Arrays.toString(mcArray));
            return Arrays.stream(mcArray).collect(Collectors.toList());
        } else {
            System.out.println("GET request did not work.");
        }

        return Collections.EMPTY_LIST;
    }

    public static class ExpressionGroup{
        public String groupName;
        public List<Expression> expressions;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<Expression> getExpressions() {
            return expressions;
        }

        public void setExpressions(List<Expression> expressions) {
            this.expressions = expressions;
        }

        @Override
        public String toString() {
            return "ExpressionGroup{" +
                    "groupName='" + groupName + '\'' +
                    ", expressions=" + expressions +
                    '}';
        }
    }

    public static class Expression {
        public String name;
        public String expressionType;
        public String expression;
        public List<String> dependencies;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExpressionType() {
            return expressionType;
        }

        public void setExpressionType(String expressionType) {
            this.expressionType = expressionType;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public List<String> getDependencies() {
            return dependencies;
        }

        public void setDependencies(List<String> dependencies) {
            this.dependencies = dependencies;
        }

        @Override
        public String toString() {
            return "Expression{" +
                    "name='" + name + '\'' +
                    ", expressionType='" + expressionType + '\'' +
                    ", expression='" + expression + '\'' +
                    ", dependencies=" + dependencies +
                    '}';
        }
    }
}
