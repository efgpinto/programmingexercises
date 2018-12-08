import scala.collection.mutable

object MyClass {
      def add(x:Int, y:Int) = x + y

      def main(args: Array[String]) {
        val in = Iterator.continually(io.StdIn.readLine).takeWhile(_.nonEmpty).toList
        var twotimes = 0
        var threetimes = 0
        in.map { line =>
            val charsMap = mutable.HashMap[String, Int]()
            line.split("").foreach(c => if (charsMap.get(c).isDefined) charsMap.put(c, charsMap(c)+1) else charsMap.put(c, 1))
            twotimes += (if (charsMap.values.count(_ == 2) == 0) 0 else 1)
            threetimes += (if (charsMap.values.count(_ == 3) == 0) 0 else 1)
            //rintln(charsMap + " :2 " + twotimes + " :3 " + threetimes)
        }
        println(twotimes * threetimes)
      }
   }


/*
import scala.collection.mutable

object MyClass {
      def add(x:Int, y:Int) = x + y;

      def main(args: Array[String]) {
        val in = Iterator.continually(io.StdIn.readLine).takeWhile(_.nonEmpty).toList
        val charsMap = mutable.HashMap[(String, Int), Int]()
        in.map { line =>
            for (i <- 0 until line.length) {
                val slicedStr = line.slice(0, i) + line.slice(i+1, line.length)
                if (charsMap.get((slicedStr,i)).isDefined) 
                    charsMap.put((slicedStr,i), charsMap((slicedStr,i))+1) 
                else 
                    charsMap.put((slicedStr, i), 1)
            }
        }
        
        println(charsMap.filter{ case (k,v) => v == 2 })
      }
   }
*/