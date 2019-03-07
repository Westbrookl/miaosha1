package com.imooc.miaosha.util;

import com.alibaba.fastjson.JSONObject;
import com.imooc.miaosha.domain.MiaoshaUser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jhc on 2019/3/6
 */
public class UserUtil {
    private static void createUser(int count) throws Exception {
        List<MiaoshaUser> miaoshaUsers = new ArrayList<MiaoshaUser>();
        for (int i = 0; i < count; i++) {
            MiaoshaUser user = new MiaoshaUser();
            user.setId(13000000000L + i);
            user.setNickname("user" + i);
            user.setSalt("1a2b3c");
            user.setLoginCount(1);
            user.setRegisterDate(new Date());
            user.setPassword(MD5Util.inputPassToDBPass("123456", user.getSalt()));
            miaoshaUsers.add(user);
        }
//        System.out.println("Create user");
//        //		//插入数据库
//        Connection conn = DBUtil.getConn();
//        String sql = "insert into miaosha_user(login_count, nickname, register_date, salt, password, id)values(?,?,?,?,?,?)";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        for (int i = 0; i < miaoshaUsers.size(); i++) {
//            MiaoshaUser user = miaoshaUsers.get(i);
//            pstmt.setInt(1, user.getLoginCount());
//            pstmt.setString(2, user.getNickname());
//            pstmt.setTimestamp(3, new Timestamp(user.getRegisterDate().getTime()));
//            pstmt.setString(4, user.getSalt());
//            pstmt.setString(5, user.getPassword());
//            pstmt.setLong(6, user.getId());
//            pstmt.addBatch();
//        }
//        pstmt.executeBatch();
//        pstmt.close();
//        conn.close();
//        System.out.println("insert to db");
        String url = "http://localhost:8080/login/do_login";
        File file = new File("D:/tokens.txt");
        if(file.exists()){
            file.delete();
        }
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        file.createNewFile();
        raf.seek(0);
        for(int i=0;i<miaoshaUsers.size();i++){
            MiaoshaUser user = miaoshaUsers.get(i);
            URL url1 = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url1.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStream out = con.getOutputStream();
            String params = "mobile="+user.getId()+"&password="+MD5Util.inputPassToFormPass("123456");
            out.write(params.getBytes());
            out.flush();
            InputStream in = con.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while((len = in.read(buff))>=0){
                bout.write(buff,0,len);
            }
            in.close();
            bout.close();
            String response = new String(bout.toByteArray());
//            System.out.println(response);
            JSONObject jo = JSONObject.parseObject(response);
            String token = jo.getString("data");
            String row = user.getId()+","+token;
//            System.out.println(token);
            System.out.println("create token "+user.getId());
            raf.seek(raf.length());
            raf.write(row.getBytes());
            raf.write("\r\n".getBytes());
            System.out.println("write to file");
        }
        raf.close();
        System.out.println("over");
    }

    public static void main(String[] args)throws  Exception{
        createUser(5000);
    }
}
