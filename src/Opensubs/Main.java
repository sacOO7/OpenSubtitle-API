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

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main( String[] args ) throws IOException, XmlRpcException {
        OpenSubtitle openSubtitle=new OpenSubtitle();
        openSubtitle.login();
//        openSubtitle.ServerInfo();
//        openSubtitle.getSubLanguages();
        openSubtitle.getMovieSubsByName("now you see me","20","eng");

//        openSubtitle.getTvSeriesSubs("game of thrones","1","1","10","eng");

//        openSubtitle.Search("/home/sachin/Vuze Downloads/Minions.2015.720p.BRRip.850MB.MkvCage.mkv");

        openSubtitle.downloadSubtitle(new URL("http://dl.opensubtitles.org/en/download/src-api/vrf-19d80c5b/sid-smrk911ll2vaj2lt5h1144mic1/filead/1954929317.gz".replaceAll(".gz","")),"tata1.txt");
        openSubtitle.logOut();
    }
}

