package lectures.part1basics

object DefaultArgs extends App {

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Picture is saved!!")
  savePicture(width = 1000) // We can name arguments!!
}
