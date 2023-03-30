package com.knoldus.map

class MapClass {

  private var mapStorage: Map[String, String] = Map.empty[String, String]

  // store the new map key-values in  storage, already defined,  return the size
  def store(map: Map[String, String]): Int = {
    mapStorage ++= map
    mapStorage.size
  }

  //simply get the value for a given key from storage
  def getValue(key: String): String = {
      mapStorage.getOrElse(key,throw new NoSuchElementException("Key not found"))
  }

  // return all the key-values of the db
  def getAllValues: Map[String, String] = {
      mapStorage
  }

  // update the value if key is present, else do nothing,  return the size
  def updateMap(key: String, value:String): Int = {
      if(mapStorage.contains(key)){
        mapStorage = mapStorage + (key -> value)
      }
      mapStorage.size
  }

  //check all the keys in db and figure out how many of them can be converted into int , filter them out by odd values and return them
  def getOddValue: Map[String, String] = {
      mapStorage.filter(values => {
        try {
          val oddValues = values._1.toInt
          oddValues % 2 != 0
        } catch {
          case _: NumberFormatException => false
        }
      })
  }

  // get the value for a given key from storage, if key is not present return empty string
  def getValuesSafely(key: String): String = {
    if(mapStorage.contains(key)) {
      mapStorage(key)
    }
    else ""
  }

}
