val func: String => String = {
    case "a" => "A"
}

func("a")
//func("b")

val func2: PartialFunction[String, String] = {
    case "a" => "A"
}

func2("a")
func2.isDefinedAt("b")
func2("c")

