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

import java.util.HashMap;

/**
 * Created by sachin on 3/4/16.
 */
public class SubtitleInfo {

    String IDSubMovieFile;
    String MovieHash,MovieByteSize,MovieTimeMS,MovieFrames,IDSubtitleFile,SubFileName,SubActualCD,SubSize,SubHash;
    String IDSubtitle,UserID,SubLanguageID,SubFormat,SubSumCD,SubAddDate,SubDownloadsCnt,SubBad,SubRating;
    String IDMovie,IDMovieImdb,MovieName,MovieNameEng,MovieYear,MovieImdbRating,UserNickName,ISO639,LanguageName,SubDownloadLink;

    SubtitleInfo (HashMap<?, ?> info){
        IDSubMovieFile= (String) info.get("IDSubMovieFile");
        MovieHash= (String) info.get("MovieHash");
        MovieByteSize=(String) info.get("MovieByteSize");
        MovieTimeMS= (String) info.get("MovieTimeMS");
        MovieFrames=(String) info.get("MovieFrames");
        IDSubtitleFile=(String) info.get("IDSubtitleFile");
        SubFileName=(String) info.get("SubFileName");
        SubActualCD=(String) info.get("SubActualCD");
        SubSize=(String) info.get("SubSize");
        SubHash=(String) info.get("SubHash");
        IDSubtitle=(String)info.get("IDSubtitle");
        UserID=(String)info.get("UserID");
        SubLanguageID=(String)info.get("SubLanguageID");
        SubFormat=(String)info.get("SubFormat");
        SubSumCD=(String)info.get("SubSumCD");
        SubAddDate=(String)info.get("SubAddDate");
        SubDownloadsCnt=(String)info.get("SubDownloadsCnt");
        SubBad=(String)info.get("SubBad");
        SubRating=(String)info.get("SubRating");
        IDMovie=(String)info.get("IDMovie");
        IDMovieImdb=(String)info.get("IDMovieImdb");
        MovieName=(String)info.get("MovieName");
        MovieNameEng=(String)info.get("MovieNameEng");
        MovieYear=(String)info.get("MovieYear");
        MovieImdbRating="tt"+(String)info.get("MovieImdbRating");
        UserNickName=(String)info.get("UserNickName");
        ISO639=(String)info.get("ISO639");
        LanguageName=(String)info.get("LanguageName");
        SubDownloadLink=(String)info.get("SubDownloadLink");

    }
    public String getIDSubMovieFile() {
        return IDSubMovieFile;
    }

    public void setIDSubMovieFile(String IDSubMovieFile) {
        this.IDSubMovieFile = IDSubMovieFile;
    }

    public String getMovieHash() {
        return MovieHash;
    }

    public void setMovieHash(String movieHash) {
        MovieHash = movieHash;
    }

    public String getMovieByteSize() {
        return MovieByteSize;
    }

    public void setMovieByteSize(String movieByteSize) {
        MovieByteSize = movieByteSize;
    }

    public String getMovieTimeMS() {
        return MovieTimeMS;
    }

    public void setMovieTimeMS(String movieTimeMS) {
        MovieTimeMS = movieTimeMS;
    }

    public String getMovieFrames() {
        return MovieFrames;
    }

    public void setMovieFrames(String movieFrames) {
        MovieFrames = movieFrames;
    }

    public String getIDSubtitleFile() {
        return IDSubtitleFile;
    }

    public void setIDSubtitleFile(String IDSubtitleFile) {
        this.IDSubtitleFile = IDSubtitleFile;
    }

    public String getSubFileName() {
        return SubFileName;
    }

    public void setSubFileName(String subFileName) {
        SubFileName = subFileName;
    }

    public String getSubActualCD() {
        return SubActualCD;
    }

    public void setSubActualCD(String subActualCD) {
        SubActualCD = subActualCD;
    }

    public String getSubSize() {
        return SubSize;
    }

    public void setSubSize(String subSize) {
        SubSize = subSize;
    }

    public String getSubHash() {
        return SubHash;
    }

    public void setSubHash(String subHash) {
        SubHash = subHash;
    }

    public String getIDSubtitle() {
        return IDSubtitle;
    }

    public void setIDSubtitle(String IDSubtitle) {
        this.IDSubtitle = IDSubtitle;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getSubLanguageID() {
        return SubLanguageID;
    }

    public void setSubLanguageID(String subLanguageID) {
        SubLanguageID = subLanguageID;
    }

    public String getSubFormat() {
        return SubFormat;
    }

    public void setSubFormat(String subFormat) {
        SubFormat = subFormat;
    }

    public String getSubSumCD() {
        return SubSumCD;
    }

    public void setSubSumCD(String subSumCD) {
        SubSumCD = subSumCD;
    }

    public String getSubAddDate() {
        return SubAddDate;
    }

    public void setSubAddDate(String subAddDate) {
        SubAddDate = subAddDate;
    }

    public String getSubDownloadsCnt() {
        return SubDownloadsCnt;
    }

    public void setSubDownloadsCnt(String subDownloadsCnt) {
        SubDownloadsCnt = subDownloadsCnt;
    }

    public String getSubBad() {
        return SubBad;
    }

    public void setSubBad(String subBad) {
        SubBad = subBad;
    }

    public String getSubRating() {
        return SubRating;
    }

    public void setSubRating(String subRating) {
        SubRating = subRating;
    }

    public String getIDMovie() {
        return IDMovie;
    }

    public void setIDMovie(String IDMovie) {
        this.IDMovie = IDMovie;
    }

    public String getIDMovieImdb() {
        return IDMovieImdb;
    }

    public void setIDMovieImdb(String IDMovieImdb) {
        this.IDMovieImdb = IDMovieImdb;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getMovieNameEng() {
        return MovieNameEng;
    }

    public void setMovieNameEng(String movieNameEng) {
        MovieNameEng = movieNameEng;
    }

    public String getMovieYear() {
        return MovieYear;
    }

    public void setMovieYear(String movieYear) {
        MovieYear = movieYear;
    }

    public String getMovieImdbRating() {
        return MovieImdbRating;
    }

    public void setMovieImdbRating(String movieImdbRating) {
        MovieImdbRating = movieImdbRating;
    }

    public String getUserNickName() {
        return UserNickName;
    }

    public void setUserNickName(String userNickName) {
        UserNickName = userNickName;
    }

    public String getISO639() {
        return ISO639;
    }

    public void setISO639(String ISO639) {
        this.ISO639 = ISO639;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }

    public String getSubDownloadLink() {
        return SubDownloadLink;
    }

    public void setSubDownloadLink(String subDownloadLink) {
        SubDownloadLink = subDownloadLink;
    }
}
