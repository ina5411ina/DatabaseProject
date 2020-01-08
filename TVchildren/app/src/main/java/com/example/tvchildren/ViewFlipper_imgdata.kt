package com.example.tvchildren

import org.json.JSONObject
import java.io.Serializable

class MovieData : Serializable {
    var movieTitle:String = ""
    var year:String = ""
    var ttconst:String = ""

    init{
        movieTitle = "N/A"
        year = "N/A"
        ttconst = "N/A"
    }

    fun parsMovieData(jsonObject: JSONObject){
        movieTitle = jsonObject.getString("primaryTitle")
        year = jsonObject.getString("startYear")
        ttconst = jsonObject.getString("movie.tconst")

    }
}



data class Imgdata(var pic:String , var name:String, var data:String): Serializable
data class ImgeUrl(var pic:String): Serializable

object datapic {
    val groups = listOf (
        Imgdata("https://movies.yahoo.com.tw/i/o/production/movies/December2019/mPiHm9jBnQg2CZKwfhiJ-1280x1830.jpg", "test1", "test1"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/October2019/aIRvKEG8wfA6YEOdrIuC-743x1100.jpg", "test2", "test2"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/zQzZYYHBrJaSI6H8dDSs-500x714.jpg", "test3", "test3"),
        Imgdata("https://movies.yahoo.com.tw/i/o/production/movies/December2019/S3Lgnrco56mwckWDwHII-504x720.jpg", "test4", "test4"),
        Imgdata("http://res.pokemon.name/common/pokemon/pgl/143.00.png", "test5", "test5")
    )
    val new = arrayListOf<Imgdata>(
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/October2019/vGXg6QY9D6iRT8JjsHuo-504x720.JPG", "test4", "test4"),
        Imgdata("https://movies.yahoo.com.tw/i/o/production/movies/December2019/xVOiTe9JQOKCLlHV6ofV-1984x2835.jpg", "test5", "test5"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/December2019/PfZQz1dOWOkyrEdNpQ4o-504x720.jpg", "test5", "test5"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/December2019/YO3BQuWczf0gyS4bkkNm-505x720.jpg", "test5", "test5"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/JmoAzUZdKfYlD71KSSsi-912x1305.jpg", "test5", "test5"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/YThUSgl1zkdp5KHXcQQB-800x1142.jpg", "test5", "test5"),
        Imgdata("https://movies.tw.campaign.yahoo.net/i/o/production/movies/October2019/xegebXu4mrEyhZjv3fam-509x720.jpg", "test5", "test5"),
        Imgdata("https://m.media-amazon.com/images/M/MV5BMjA0YjYyZGMtN2U0Ni00YmY4LWJkZTItYTMyMjY3NGYyMTJkXkEyXkFqcGdeQXVyNDg4NjY5OTQ@._V1_SY1000_SX675_AL_.jpg", "test5", "test5")
    )

}

object IMG{
    val yearly_pic_list = listOf (
        ImgeUrl("https://movies.yahoo.com.tw/i/o/production/movies/December2019/mPiHm9jBnQg2CZKwfhiJ-1280x1830.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/October2019/aIRvKEG8wfA6YEOdrIuC-743x1100.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/zQzZYYHBrJaSI6H8dDSs-500x714.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/zQzZYYHBrJaSI6H8dDSs-500x714.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/ImU5rtOmf9dYHJsoV28b-800x1143.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/O6jhWHvEHNgqvSmQlHH3-800x1142.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/September2019/XWmfMq6Kx4SIPZrGaWFW-504x720.JPG"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/GeHWrPAcRp3CqDMjSZ3D-800x1154.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/October2019/vGXg6QY9D6iRT8JjsHuo-504x720.JPG"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/JmoAzUZdKfYlD71KSSsi-912x1305.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/June2019/Yhk2peIL82Ht2Yt3ngFo-486x720.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/kOwpmZXR7aE4YxeqZ9U8-800x1142.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/December2019/F3BpOiQNy32UWXo83KZz-648x960.jpg"),
        ImgeUrl("https://movies.yahoo.com.tw/i/o/production/movies/December2019/S3Lgnrco56mwckWDwHII-504x720.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/YThUSgl1zkdp5KHXcQQB-800x1142.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/November2019/ET5eaXriPZGLmo9FxKE3-800x1142.jpg"),
        ImgeUrl("https://movies.yahoo.com.tw/i/o/production/movies/November2019/UB2DtOHpyRMAXvhwIR7g-800x1142.jpg"),
        ImgeUrl("https://movies.yahoo.com.tw/i/o/production/movies/November2019/ZIs2BN9B9KyEbgZYs3Nl-800x1154.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/December2019/PfZQz1dOWOkyrEdNpQ4o-504x720.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/December2019/YO3BQuWczf0gyS4bkkNm-505x720.jpg"),
        ImgeUrl("https://movies.tw.campaign.yahoo.net/i/o/production/movies/October2019/oAaDIZan8DBhqSyOm4AW-505x720.jpg"),
        ImgeUrl("https://movies.yahoo.com.tw/i/o/production/movies/December2019/xVOiTe9JQOKCLlHV6ofV-1984x2835.jpg")
    )
}