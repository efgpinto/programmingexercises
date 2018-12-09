package day4

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

import scala.collection.immutable.TreeMap
import scala.collection.mutable
import scala.io.Source

object ReposeRecord extends App {

  val pattern = "\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})\\] (.*)".r
  val patternAction = "Guard #(\\d+) .*".r
  val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm")

  // part 1 assertions
  val result = part1("src/adventofcode/day4/small.txt")
  assert(result == 240, s"Wrong: $result")

  val result2 = part1("src/adventofcode/day4/input.txt")
  assert(result2 == 87681, s"Wrong: $result2")

  // part 2 assertions
  val result3 = part2("src/adventofcode/day4/small.txt")
  assert(result3 == 4455, s"Wrong: $result3")

  val result4 = part2("src/adventofcode/day4/input.txt")
  assert(result4 == 136461, s"Wrong: $result4")

  def buildTimeline(file: String): TreeMap[Date, String] = {
    Source.fromFile(file).getLines.toStream
      .foldLeft(TreeMap.empty[Date, String]) { (acum, line) =>
        val pattern(datetime, action) = line
        acum + (sdf.parse(datetime) -> action)
      }
  }

  def part1(file: String): Int = {
    val timelineAsc = buildTimeline(file).toSeq.sortBy(_._1)

    val sleepById = mutable.HashMap[String, Array[Int]]()
    var guardId: String = "0"
    var beginSleep = 0

    timelineAsc.foreach { case (key, value) =>

      val cal = Calendar.getInstance
      cal.setTime(key)
      val min = cal.get(Calendar.MINUTE)
      val hour = cal.get(Calendar.HOUR_OF_DAY)

      value match {
        case patternAction(id) => guardId = id
        case sleep if sleep.startsWith("falls") && hour >= 0 => beginSleep = min
        case wake if wake.startsWith("wakes") =>

          val old = sleepById.getOrElseUpdate(guardId, Array.fill[Int](60)(0))
          for (m <- beginSleep until min) old.update(m, old(m)+1)
          sleepById.put(guardId, old)
      }
    }

    val sleepierId = sleepById.maxBy(_._2.sum)._1
    val sleepierMin = sleepById(sleepierId).zipWithIndex.maxBy(_._1)._2
    sleepierId.toInt * sleepierMin
  }

  def part2(file: String): Int = {
    val timelineAsc = buildTimeline(file).toSeq.sortBy(_._1)

    // debug
    //timelineAsc.foreach { case (k, v) => println(s"$k -> $v") }

    val sleepById = mutable.HashMap[String, Array[Int]]()
    var guardId: String = "0"
    var beginSleep = 0

    timelineAsc.foreach { case (key, value) =>

      val cal = Calendar.getInstance
      cal.setTime(key)
      val min = cal.get(Calendar.MINUTE)
      val hour = cal.get(Calendar.HOUR_OF_DAY)

      value match {
        case patternAction(id) => guardId = id
        case sleep if sleep.startsWith("falls") => beginSleep = if (hour >= 0) min else 0
        case wake if wake.startsWith("wakes") =>
          val old = sleepById.getOrElseUpdate(guardId, Array.fill[Int](60)(0))
          for (m <- beginSleep until min) old.update(m, old(m)+1)
          sleepById.put(guardId, old)
      }
    }

    // debug
    //sleepById.foreach { case (k, v) => println(s"$k -> " + v.mkString(",")) }

    val guard = sleepById.map { case (k, v) =>
      k -> v.zipWithIndex.maxBy(_._1)
    }.maxBy(_._2._1)

    guard._1.toInt * guard._2._2
  }
}