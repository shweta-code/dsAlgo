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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws IOException {

        // ObjectMapper mapper =
        // Validate input size is 3
        String field = inputList.get(0);
        String operation = inputList.get(1);
        String value = inputList.get(2);

        String[] values = value.split(",");

        List<User> usersList = getListOfUsers1();
        List<Integer> ids = new ArrayList<>();

        for (User user : usersList) {
            switch (field)
            {
                case "username":
                {
                    switch (operation){
                        case "EQUALS":
                            if(user.getUsername().equals(value)){
                                ids.add(user.getId());
                            }
                        case "IN":
                            if(Arrays.stream(values).anyMatch(x -> x.equals(user.getUsername()))){
                                ids.add(user.getId());
                            }
                    }
                }


            }
        }

        if(ids.isEmpty()){
            Integer[] ans = new Integer[]{-1};
            return Arrays.asList(ans);
        }
        System.out.println(ids.size());
        return ids;

    }


    private static List<User> getListOfUsers1() throws IOException {
        URL obj = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
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
            System.out.println(response.toString());
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            List<User> users = gson.fromJson(response.toString(), listType);

            User[] mcArray = gson.fromJson(response.toString(), User[].class);
            return Arrays.stream(mcArray).collect(Collectors.toList());
        } else {
            System.out.println("GET request did not work.");
        }

        return Collections.EMPTY_LIST;
    }

    public static void main(String[] args) {
        try {
            getListOfUsers1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  enum Operator{

        EQUALS("=") {
            @Override
            public <T,V> boolean operate(T comparer, V compared) {
                if(!comparer.getClass().equals(compared.getClass()))
                    return false;
                return comparer.equals(compared);

            }
        };


        private String symbol;

        public abstract <T,V> boolean operate(T compared, V comparer);

        Operator(String symbol) {
            this.symbol = symbol;
        }
    }
    public static class User{

        private Integer id;
        private String username;
        private String name;
        private String email;
        private Address address;
        private String website;
        private Company company;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }


    }

    public static class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }
    }

    public static class Geo{
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }

    public static class Company{
        private String name;
        private String basename;

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}




