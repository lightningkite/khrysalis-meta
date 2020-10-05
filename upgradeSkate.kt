import java.io.File

fun main(){
    println("Enter folder:")
    val folder: File = File(readLine()!!)

    val widgetFix = Regex("com\\.lightningkite\\.butterfly\\.([a-zA-Z]+\\.)*")

    folder
            .listFiles()!!
            .asSequence()
            .flatMap { it.walkBottomUp() }
            .filter {
                !it.path.contains("node_modules") &&
                        !it.path.contains(".git")  &&
                        !it.path.contains("Pods")  &&
                        it.extension != "png"  &&
                        it.extension != "svg"  &&
                        it.extension != "bin"  &&
                        !it.path.contains("Pods")  &&
                        !it.path.contains("build/")
            }
            .forEach {
                if(it.isFile && it.name != "AndroidManifest.xml" && !it.name.contains("gradle", true)){
                    it.writeText(it.readText()
                            .replace("Khrysalis", "Butterfly")
                            .replace("khrysalis", "butterfly")
                            .replace("KHRYSALIS", "BUTTERFLY")
                    )
                    if(it.extension == "xml" && it.path.contains("layout")) {
                        it.writeText(it.readText().replace(widgetFix, "com.lightningkite.butterfly.views.widget."))
                    }
                }
                if(it.name.contains(".shared")) {
                    val newName = it.parentFile.resolve(it.name.replace(".shared", ""))
                    it.writeText("//! This file will translate using Khrysalis.\n" + it.readText())
//                    if(!newName.exists()) {
                        it.renameTo(newName)
//                    }
                }
                if(it.name.contains(".actual")) {
                    val newName = it.parentFile.resolve(it.name.replace(".actual", ""))
                    if(!newName.exists()) {
                        it.renameTo(newName)
                    }
                }
            }
}