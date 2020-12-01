import com.lightningkite.khrysalis.gradle.KhrysalisPluginExtension
group = "org.example"
version = "1.0-SNAPSHOT"


buildscript {
    val kotlin_version = "1.3.72"
    repositories {
        google()
        jcenter()
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.lightningkite.khrysalis:plugin:0.1.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

//subprojects {
//    if(this.name.contains("butterfly")) {
//        val baseName = this.name.removeSuffix("-android")
//
//        apply(plugin = "com.lightningkite.khrysalis")
//
//        configure<KhrysalisPluginExtension> {
//            val p = when(baseName){
//                "butterfly-fcm" -> "ButterflyFCM"
//                else -> baseName.split('-').joinToString("") { it.capitalize() }
//            }
//            println("Configured name is $p")
//            projectName = p
//            organizationName = "Lightning Kite"
//            overrideIosFolder = project.projectDir.resolve("../../$baseName-ios").toString()
//            overrideWebFolder = project.projectDir.resolve("../../$baseName-web").toString()
//        }
//    }
//}