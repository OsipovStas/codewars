object DuplicateEncoder {
  def duplicateEncode(word: String): String = {
    val lowerCase = word.toLowerCase
    lowerCase.map {
      case c if lowerCase.length - lowerCase.replace(c.toString, "").length > 1 => ')'
      case _ => '('
    }
  }
}
