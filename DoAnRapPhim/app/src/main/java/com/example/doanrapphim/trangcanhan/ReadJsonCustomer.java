package com.example.doanrapphim.trangcanhan;

import android.content.Context;

import com.example.doanrapphim.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJsonCustomer {
    public static customer readCompanyJSONFile(Context context) throws IOException, JSONException {
        String jsonText = readText(context, R.raw.info_customer);

        JSONObject jsonRoot = new JSONObject(jsonText);

        String username = jsonRoot.getString("username");
        String name = jsonRoot.getString("name");
        String phone = jsonRoot.getString("phone");
        String email = jsonRoot.getString("email");

        customer Customer = new customer();
        Customer.setUsername(username);
        Customer.setName(name);
        Customer.setPhone(phone);
        Customer.setEmail(email);
        return Customer;

//        JSONObject jsonRoot = new JSONObject(jsonText);
//
//        int id= jsonRoot.getInt("id");
//        String name= jsonRoot.getString("name");
//
//        JSONArray jsonArray = jsonRoot.getJSONArray("websites");
//        String[] websites = new String[jsonArray.length()];
//
//        for (int i=0; i<jsonArray.length(); i++) {
//            websites[i] = jsonArray.getString(i);
//        }
//
//        JSONObject jsonAddress = jsonRoot.getJSONObject("address");
//        String  street = jsonAddress.getString("street");
//        String city = jsonAddress.getString("city");
//        Address address = new Address(street, city);
//
//        Company company = new Company();
//        company.setId(id);
//        company.setName(name);
//        company.setAddress(address);
//        company.setWebsites(websites);
//        return company;
    }

    private static String readText(Context context, int resId) throws IOException{
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while(( s= br.readLine()) !=null){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
