import scala.io.Source
import java.io.PrintWriter

object Tasks {
  //task 1 -------------------------------------------------------------------------------------------------------------
  //variant 2
  //Download Exports and Imports of India(1997-2022)


  //task 2 -------------------------------------------------------------------------------------------------------------
  def readFile(filePath: String, delimiter: String): Array[Array[String]] = {
    val delimiterCondition = delimiter ++ "(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"
    val fileFullPath = getClass.getResource(filePath)
    val file = Source.fromFile(fileFullPath.getPath)
    val data = file.getLines().toArray.map(_.split(delimiterCondition))
    file.close()
    data
  }


  //task 5 -------------------------------------------------------------------------------------------------------------
  def sortDataByCountryDesc(data: Array[Array[String]]): Array[Array[String]] = {
    val revert = data.sortWith(_(0) > _(0))
    revert
  }


  //task 6 -------------------------------------------------------------------------------------------------------------
  def removeYearEnd(data: Array[Array[String]]): Array[Array[String]] = {
    val updatedData = data.map(a => {
      val (clearedData, yearEnd) = a.splitAt(6)
      clearedData
    })
    updatedData
  }


  //task 7 -------------------------------------------------------------------------------------------------------------
  def sortDataByExport(data: Array[Array[String]]): Array[Array[String]] = {
    val (filledExportData, emptyExportData) = data.partition { row =>
      row.length > 1 && row(1).replace(",", "").replace("\"", "").nonEmpty
    }
    val sortedData = filledExportData.sortWith(
      _(1).replace(",", "").replace("\"", "").toDouble < _(1).replace(",", "").replace("\"", "").toDouble
    )
    emptyExportData ++ sortedData
  }


  //task 8 -------------------------------------------------------------------------------------------------------------
  def addColumnMean(data: Array[Array[String]]): Array[Array[String]] = {
    val newData = data.map(a => {
      val val1 = a(3).replace(",", "").replace("\"", "").toDoubleOption.getOrElse(0.0)
      val val2 = a(4).replace(",", "").replace("\"", "").toDoubleOption.getOrElse(0.0)
      a ++ Array(((val1 + val2) / 2).toString)
    })
    newData
  }


  //task 9 -------------------------------------------------------------------------------------------------------------
  def findMinValue(data: Array[Array[String]], column: Int): String = {
    val sortData = data.sortWith(_(column) < _(column))
    sortData(0)(column)
  }


  //task 10 ------------------------------------------------------------------------------------------------------------
  def createFile(data: Array[Array[String]], name: String): Unit = {
    val fileName = s"$name.csv"
    val writer = new PrintWriter(fileName)
    data.foreach(row => writer.println(row.mkString(",")))
  }
}
