package com.scalayadu.main
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import java.io.PrintWriter
import java.io.File
import java.time.LocalDate
import java.io.FileOutputStream

object Launcher {
  
  def main(args: Array[String]):Unit = {
    
    val tracker_file = "task_tracker.txt"
    
    val tasks: Array[String] = Array(
      "Meditation",
      "drinking water in the morning",
      "drinking water - 3 litres",
      "Breakfast",
      "Lunch for office",
      "Reaching office by 9am",
      "Headspace reminder 3 times",
      "Workout - gym/rqt ball",
      "Introspection",
      "Reading a book before sleeping"
    )
    
    var task_track: Array[String] = new Array(tasks.length)
    System.out.println("Enter Y for done, N for not done")
    for(task_index <- tasks.indices){
      System.out.print(tasks(task_index) + " : ") 
      task_track(task_index) = if(readLine().capitalize == "Y") "YES" else "NO"
    }
    
    System.out.println(task_track.toString())
    
    val writer = new PrintWriter(new FileOutputStream(new File(tracker_file), true))
    //System.out.println(writer.p)
    writeToFile(task_track,tasks,writer)
    //writer.append(writeToFile(task_track))
    writer.close()
  }
  
  def writeToFile(task_track: Array[String], tasks: Array[String], writer:PrintWriter) = {
    //var csv_line = ""
    writer.append("---------------------------------" + "Date: " + LocalDate.now() + "---------------------------------" + "\n")
    for(task_ind <- tasks.indices){
      val line = tasks(task_ind) + ": " + task_track(task_ind)
      writer.append(line + "\n")
    }
    writer.append("------------------------------------------------------------------" + "\n")
  }
  
}