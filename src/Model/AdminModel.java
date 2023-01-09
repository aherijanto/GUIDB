package Model;

import Network.ConnectURI;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdminModel {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    private String id;
    private String name;
    private String pwd;
    private String phone;

    public AdminModel(String id, String name, String pwd,String phone) {
        this.id=id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
    }

    public String ConvertToJSON(){
        JSONArray jsonUser= new JSONArray();
        JSONObject myJObject = new JSONObject();
        myJObject.put("idadmin",this.id);
        myJObject.put("name",this.name);
        myJObject.put("passwd",this.pwd);
        myJObject.put("nohp",this.phone);
        jsonUser.put(myJObject);
        return jsonUser.toString();
    }
    public AdminModel(){}
    
    public ArrayList<AdminModel> DataTransform(String res){
        
        JSONArray adminArray = new JSONArray(res);
        JSONObject myJSONObject;
        int index = adminArray.length();
        ArrayList<AdminModel> DataAdmin = new ArrayList<AdminModel>();
        for (int i = 0; i < index; i++) {
            AdminModel s = new AdminModel();
            myJSONObject = adminArray.getJSONObject(i);
            s.setId(myJSONObject.getString("id_admin"));
            s.setName(myJSONObject.getString("nama"));
            s.setPhone(myJSONObject.getString("no_hp"));
            
            DataAdmin.add(s);
        }
        return DataAdmin;
    }
}
