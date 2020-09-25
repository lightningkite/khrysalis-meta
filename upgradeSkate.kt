import java.io.File

fun main(){
    println("Enter folder:")
    val folder: File = File(readLine()!!)

    val widgetFix =

    folder.walkBottomUp()
            .forEach {
                if(it.isFile){
                    it.writeText(it.readText()
                            .replace("Khrysalis", "Butterfly")
                            .replace("khrysalis", "butterfly")
                            .replace("KHRYSALIS", "BUTTERFLY")
                    )
                    if(it.extension == "xml") {
                        it.writeText(it.readText().replace())
                    }
                }
                if(it.name.contains(".shared")) {
                    val newName = it.parentFile.resolve(it.name.replace(".shared", ""))
                    it.writeText("//! This file will translate using Khrysalis.\n" + it.readText())
                    if(!newName.exists()) {
                        it.renameTo(newName)
                    }
                }
            }
}