package com.example.amatorfutbol.parser

import android.util.Log
import android.widget.Toast
import com.example.amatorfutbol.models.TeamModel
import com.example.amatorfutbol.objects.AppObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class HtmlParser {

    val urlTrabzon: String = "http://www.amatorfutbol.org/askf/trabzon/puandurumu-7055.html"
/*
    fun group():ArrayList<String>{
        Thread(Runnable {
            try{
                val doc:Document = Jsoup.connect(urlTrabzon).get()
                val elements: Elements = doc.select("small").select("ul").select("li")


            }catch (e: Exception){
                Log.e("TAG", "group: Error", )
            }

        }).start()
    }
 */

    fun puanTablosu():ArrayList<TeamModel>{

        var list = ArrayList<TeamModel>()
        Thread(Runnable {
            try{
                Log.d("TAG", "puanTablosu: Geldi")
                val doc: Document = Jsoup.connect(AppObject.url).get()
                val elements: Elements = doc.select("table#puandurumu").select("tbody").select("tr.hucre")

                for (element in elements){
                    val teamName = element.select("td").get(2).text()
                    val teamMatch =element.select("td").get(3).text()
                    val teamWin = element.select("td").get(4).text()
                    val teamDraw = element.select("td").get(5).text()
                    val teamLose = element.select("td").get(6).text()
                    val teamPoint = element.select("td").get(10).text()

                    var model =TeamModel(teamName,teamMatch,teamWin,teamDraw,teamLose,teamPoint)
                    list.add(model)
                    Log.d("TAG", "puanTablosu: "+ teamName)
                }

            }catch (e: Exception){
                Log.e("TAG", "group: Error", )
            }
        }).start()

        return list
    }
}