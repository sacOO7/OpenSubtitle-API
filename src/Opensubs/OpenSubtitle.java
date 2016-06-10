/*
 * Copyright 2016  sachin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package Opensubs;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.GZIPInputStream;







/**
 * Created by sachin on 7/4/16.
 */
public class OpenSubtitle {
    private static String OPEN_SUBTITLES_SERVER="http://api.opensubtitles.org/xml-rpc";
    private static String MOVIE_EXTENSIONS="mp4,mkv,avi,mov";

    XmlRpcClientConfigImpl xmlRpcClientConfig;
    XmlRpcClient xmlRpcClient;
    String strToken="";
    String fileHash="";
    File movie;
    FilenameFilter fileNameFilter;
    ArrayList movieFileExtensions;


    public OpenSubtitle(){
        xmlRpcClientConfig=new XmlRpcClientConfigImpl();
        xmlRpcClient=new XmlRpcClient();
        movieFileExtensions=new ArrayList();
        String movieExtensionArray[]=MOVIE_EXTENSIONS.split(",");
        for(String extn : movieExtensionArray ){
            movieFileExtensions.add(extn);
        }


        try {
            xmlRpcClientConfig.setServerURL(new URL(OPEN_SUBTITLES_SERVER));
            xmlRpcClient.setConfig(xmlRpcClientConfig);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void ServerInfo() throws XmlRpcException {
        HashMap<?,?> retVal;
        retVal=(HashMap)xmlRpcClient.execute("ServerInfo", (Object[]) null);
        System.out.println("ServerInfo"+retVal.toString());
    }

    public List<SubtitleInfo>SearchMoviesOnImdb(String moviename) throws XmlRpcException {

        List <SubtitleInfo> infos=new ArrayList<>();
        HashMap<?,?> retVal;
        List params=new ArrayList();
        params.add(strToken);
        params.add(moviename);
        retVal=(HashMap)xmlRpcClient.execute("SearchMoviesOnIMDB", params);
//        System.out.println("ServerInfo"+retVal.toString());
        if(retVal.get("data") instanceof Object[]){
            Object[] data=(Object [])retVal.get("data");
            for (int i=0;i<data.length;i++) {
                SubtitleInfo info=new SubtitleInfo((HashMap<?, ?>) data[i]);
                System.out.println("Id is"+info.getIDMovie());
                System.out.println("title is"+info.getMovieName());
//                System.out.println("Link is"+info.getSubDownloadLink());
                infos.add(info);
            }
        }
        return infos;
    }

    public List<SubtitleInfo> getMovieSubsByName(String moviename,String limit,String language) throws XmlRpcException {

        List <SubtitleInfo> infos=new ArrayList<>();
        HashMap<?,?> retVal;
        List params=new ArrayList();
        params.add(strToken);
        HashMap <String,Object> query = new HashMap<>();
        query.put("query",moviename);
        query.put("sublanguageid",language);
        HashMap <String,Object> query2=new HashMap<>();
        query2.put("limit", limit);
        Object[] paramsArray = new Object[]{strToken, new Object[]{query},query2};
        retVal=(HashMap)xmlRpcClient.execute("SearchSubtitles", paramsArray);
        System.out.println("Status code is "+retVal.get("status"));
        if(retVal.get("data") instanceof Object[]){
            Object[] data=(Object [])retVal.get("data");
            for (int i=0;i<data.length;i++) {
                SubtitleInfo info=new SubtitleInfo((HashMap<?, ?>) data[i]);
                System.out.println("Id is "+info.getIDMovieImdb());
                System.out.println("title is "+info.getMovieName());
                System.out.println("Link is "+info.getSubDownloadLink());
                System.out.println("Language is "+info.getLanguageName());
                System.out.println("IMDB rating is "+info.getMovieImdbRating());
                System.out.println("Year is "+info.getMovieYear());
                System.out.println("Sub file name "+info.getSubFileName());
                System.out.println("Date is "+info.getSubAddDate());
                System.out.println("Rating is "+info.getSubRating());
                System.out.println("Downloads is "+info.getSubDownloadsCnt());
                System.out.println("Actual CD name "+info.getSubActualCD());
                System.out.println("Bad is "+info.getSubBad());
                infos.add(info);
            }
        }
        System.out.println("Total subs length is " + ((Object[]) retVal.get("data")).length);
        return infos;
    }

    public List<SubtitleInfo> getTvSeriesSubs(String TvseriesName,String season,String episode,String limit,String language) throws XmlRpcException {

        List <SubtitleInfo> infos=new ArrayList<>();
        HashMap<?,?> retVal;
        List params=new ArrayList();
        params.add(strToken);
        HashMap <String,Object> query = new HashMap<>();
        query.put("query",TvseriesName);
        query.put("season", season);
        query.put("episode",episode);
        query.put("sublanguageid", language);
        HashMap <String,Object> query2=new HashMap<>();
        query2.put("limit", limit);
        Object[] paramsArray = new Object[]{strToken, new Object[]{query},query2};
        retVal=(HashMap)xmlRpcClient.execute("SearchSubtitles", paramsArray);
        System.out.println("Status code is " + retVal.get("status"));
        if(retVal.get("data") instanceof Object[]){
            Object[] data=(Object [])retVal.get("data");
            for (int i=0;i<data.length;i++) {
                SubtitleInfo info=new SubtitleInfo((HashMap<?, ?>) data[i]);
                System.out.println("Id is "+info.IDMovieImdb);
                System.out.println("title is "+info.getMovieName());
                System.out.println(info.getSubDownloadLink());
                infos.add(info);
            }
        }
        System.out.println("Total subs length is " + ((Object[]) retVal.get("data")).length);
        return infos;
    }
    public void getIMDBmovieDetails(String imdbId) throws XmlRpcException {

        HashMap<?,?> retVal;
        List params=new ArrayList();
        params.add(strToken);
        params.add(imdbId);
        retVal=(HashMap)xmlRpcClient.execute("SearchMoviesOnIMDB", params);
        if(retVal.get("data") instanceof Object[]) {
            Object[] data = (Object[]) retVal.get("data");
            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i].toString());
            }
        }

    }

    public void getDetailsFromOmdb(String imdbid) throws IOException {
        URL oracle = new URL("http://www.omdbapi.com/?i="+"tt"+imdbid);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

    public void getSubLanguages() throws XmlRpcException {
        HashMap<?,?> retVal;
        retVal=(HashMap)xmlRpcClient.execute("GetSubLanguages", (Object[]) null);
//        System.out.println("ServerInfo"+retVal.toString());
        if(retVal.get("data") instanceof Object[]) {
            Object[] data = (Object[]) retVal.get("data");
            for (int i = 0; i < data.length; i++) {
                System.out.println(((HashMap<?,?>)data[i]).toString());
            }
            System.out.println("Length is "+data.length);
        }

    }

    public String login() throws XmlRpcException{
        List params=new ArrayList();
        HashMap<?,?> retVal;

        params.add("");
        params.add("");
        params.add("eng");
        params.add("moviejukebox 1.0.15");
            retVal=(HashMap)xmlRpcClient.execute("LogIn", params);
            strToken = (String) retVal.get("token");
        return strToken;

    }

    public void logOut(){
        List params=new ArrayList();
        params.add(strToken);
        try {
            xmlRpcClient.execute("LogOut",params);
        } catch (XmlRpcException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void computeHash(String filePath){
        try {
            movie=new File(filePath);
            fileHash=OpenSubtitleHasher.computeHash(movie);
            System.out.println(fileHash);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public List <SubtitleInfo> Search(String filePath) throws XmlRpcException {
        computeHash(filePath);
        List <SubtitleInfo> infos=new ArrayList<>();
        Map<String, Object> parameterMap = new HashMap();
//        System.out.println(fileHash);
//        System.out.println(movie.length());
        HashMap<?, ?> retVal;
        parameterMap.put("sublanguageid", Locale.getDefault().getISO3Language());
        parameterMap.put("moviehash", fileHash);
        String fileName = movie.getName();
        fileName = fileName.substring(0, fileName.length() - 4);
        System.out.println(fileName);
        Object[] paramsArray = new Object[]{strToken, new Object[]{parameterMap}};
        retVal = (HashMap<?, ?>) xmlRpcClient.execute("SearchSubtitles", paramsArray);
        System.out.println("Status code is " + retVal.get("status"));
        if (retVal.get("data") instanceof Object[]) {
            Object[] data = (Object[]) retVal.get("data");
            for (int i = 0; i < data.length; i++) {
                SubtitleInfo info = new SubtitleInfo((HashMap<?, ?>) data[i]);
//                System.out.println("Id is " + info.getIDMovieImdb());
                System.out.println("title is " + info.getMovieName());
                System.out.println("Hash is "+info.getMovieHash());
                System.out.println("Link is " + info.getSubDownloadLink());
                System.out.println("Language is " + info.getLanguageName());
                System.out.println("IMDB rating is " + info.getMovieImdbRating());
                System.out.println("Year is " + info.getMovieYear());
                System.out.println("Sub file name " + info.getSubFileName());
                System.out.println("Date is " + info.getSubAddDate());
                System.out.println("Rating is " + info.getSubRating());
                System.out.println("Downloads is " + info.getSubDownloadsCnt());
                System.out.println("Actual CD name " + info.getSubActualCD());
                System.out.println("Bad is " + info.getSubBad());
                infos.add(info);
            }
        }
        System.out.println("Total subs length is " + ((Object[]) retVal.get("data")).length);

        return infos;
    }

    public  String getExtension(HttpURLConnection webConnection) {

        try {

            String strContentDisposition = webConnection.getHeaderField("Content-Disposition");
            System.out.println(strContentDisposition);
            String strExtention = strContentDisposition.replaceAll(".*\\.([a-z]{3})\\..*", "$1");

            return strExtention;

        } catch (Exception e) {
            return null;
        }

    }

    public void downloadSubtitle(URL url,String filename) throws IOException {

        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine,total="";
        while ((inputLine = in.readLine()) != null)
            total+=inputLine+"\n";
        in.close();
        BufferedWriter output = null;
        try {
            File filSubtitleFile = new File(filename);
            output = new BufferedWriter(new FileWriter(filSubtitleFile));
            output.write(total);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }

        // Now that we have the URL, we can download the file. The file is in
        // the GZIP format so we have to uncompress it.
//        File filSubtitleFile = new File(filename);
//
//        HttpURLConnection httpConnection = null;
//        FileOutputStream fileOutputStream = null;
//        GZIPInputStream gzipInputStream = null;
//
//        try {
//
//            httpConnection = (HttpURLConnection)((url).openConnection());
//            fileOutputStream = new FileOutputStream(filSubtitleFile);
//            gzipInputStream = new GZIPInputStream(httpConnection.getInputStream());
//
//
//
//            Integer intLength = 0;
//            byte[] bytBuffer = new byte[1024];
//
//            fileOutputStream.close();
//            filSubtitleFile.delete();
//            if (httpConnection.getHeaderField("Content-Disposition").isEmpty() == false) {
//                filSubtitleFile = new File(filSubtitleFile.getPath());
//            }
//
//            fileOutputStream.close();
//            fileOutputStream = new FileOutputStream(filSubtitleFile);
//            while ((intLength = gzipInputStream.read(bytBuffer)) > 0) {
//                fileOutputStream.write(bytBuffer, 0, intLength);
//            }
//            httpConnection.disconnect();
//
//
//
//        } catch (Exception e) {
//
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            try {
//                gzipInputStream.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }




    }
//
//    public void searchAndDownloadDirectory(File dir){
//        if(dir.isDirectory()){
//            File files[]=dir.listFiles();
//            for(File f: files){
//                if(f.isDirectory()){
//                    searchAndDownloadDirectory(f);
//                }
//                else{
//                    if(isVideoFile(f)){
//                        Search(f.getAbsolutePath());
//                    }
//                }
//            }
//        }
//    }

    private boolean isVideoFile(File f) {
        String fileName=f.getName();
        String extension=fileName.substring(fileName.lastIndexOf('.')+1);
        if(movieFileExtensions.contains(extension)){
//            System.out.println("hey!!! its a video file"+f.getName());
            return true;
        }
        return false;
    }
}
