package DataDriven;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestFillo {

    public static Map<String,String> getData() throws FilloException {
        Fillo fl = new Fillo();
        String path = "./EndPoints\\EndPoints.xlsx";
        File file = new File(path);
        Connection con = null;
        try {
            con = fl.getConnection(file.getAbsolutePath());
        } catch (FilloException e) {
            e.printStackTrace();
        }
        String query = "Select * from Sheet1";
        Recordset set = null;
        try {
            set = con.executeQuery(query);
        } catch (FilloException e) {
            e.printStackTrace();
        }

//        Object [][] obj = new Object[1][1];
        Map<String,String> mp = new LinkedHashMap<String,String>();
        while (set.next()){
//            StringBuilder builder = new StringBuilder();
            mp.put(set.getField("TestCase"),set.getField("Endpoint"));
        }


        return mp;
    }
}
