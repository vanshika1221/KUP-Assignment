package com.knoldus.seq

class Sequence {

  private var sequenceString: Seq[String] = Seq.empty[String]
  private var sequenceInt: Seq[Int] = Seq.empty[Int]

  //Check the type of element, if it is int save it to sequenceInt, if it is string save it to sequenceString, else return IllegalArgumentException,  return the size
  def store(element: Any): Int = {
    element match {
      case comingValue: Int => sequenceInt = sequenceInt :+ comingValue
      sequenceInt.size
      case comingValue: String => sequenceString = sequenceString :+ comingValue
      sequenceString.size
      case _ => throw new IllegalArgumentException("Type not supported")
    }
  }

  // Check the type of element, if it is int remove it from sequenceInt, if it is string remove it from sequenceString, else return IllegalArgumentException,  return the size
  def removeElement(element: Any): Int = {
    element match {
      case comingValue: Int => sequenceInt = sequenceInt.filter(_ != comingValue)
      sequenceInt.size
      case comingValue: String => sequenceString = sequenceString.filter(_ != comingValue)
      sequenceString.size
      case _ => throw new IllegalArgumentException("Type not supported")
    }
  }

}
