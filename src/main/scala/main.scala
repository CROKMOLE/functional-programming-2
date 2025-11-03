/**
 * that lab includes solutions for tasks for second variant
 * the data set names: Exports and Imports of India(1997-2022)
 * Variant II
 */

@main
def main(): Unit = {
  //task 2 -------------------------------------------------------------------------------------------------------------
  val df = Tasks.readFile("data.csv", ",")
  /*
  additional: printing of the data from file
  commented by reason of big amount of data that is printed to the terminal
  all next not required prints is commented to simplify testing and reading the result
  */
//  df.foreach(row => println(row.mkString(", ")))


  //task 3 -------------------------------------------------------------------------------------------------------------
  val(header, data) = df.splitAt(1)
  println("Table Headers =============================================================================================")
//  header.foreach(row => println(row.mkString(" | ")))


  //task 4 -------------------------------------------------------------------------------------------------------------
  val(firstPart, secondPart) = data.splitAt(5)
//  firstPart.foreach(row => println(row.mkString(", ")))


  //task 5 -------------------------------------------------------------------------------------------------------------
  val sortedData = Tasks.sortDataByCountryDesc(data)
//  sortedData.foreach(row => println(row.mkString(", ")))


  //task 6 -------------------------------------------------------------------------------------------------------------
  val clearedData = Tasks.removeYearEnd(sortedData)
  val clearedHeader = Tasks.removeYearEnd(header)
//  clearedData.foreach(row => println(row.mkString(", ")))


  //task 7 -------------------------------------------------------------------------------------------------------------
  val secondarySortedData = Tasks.sortDataByExport(clearedData)
//  secondarySortedData.foreach(row => println(row.mkString(", ")))


  //task 8 -------------------------------------------------------------------------------------------------------------
  val newHeader = clearedHeader.map(a => {
    a ++ Array("Mean")
  })
//  newHeader.foreach(row => println(row.mkString(" | ")))
  val newData = Tasks.addColumnMean(secondarySortedData)
//  newData.foreach(row => println(row.mkString(", ")))


  //task 9 -------------------------------------------------------------------------------------------------------------
  println(Tasks.findMinValue(newData, 5))


  //task 10 ------------------------------------------------------------------------------------------------------------
  Tasks.createFile(newHeader ++ newData, "newData.csv")
}