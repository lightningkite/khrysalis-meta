rootProject.name = "khrysalis-meta"

pluginManagement {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-eap")

        mavenCentral()

        maven("https://plugins.gradle.org/m2/")
    }
}

fun includeDeep(string: String, folder: String = string){
    include(string)
    project(":" + string).projectDir = file("$folder/$string")
}

includeDeep("kotlin-compiler-plugin-common", "khrysalis")
includeDeep("kotlin-compiler-plugin-swift", "khrysalis")
includeDeep("kotlin-compiler-plugin-typescript", "khrysalis")
includeDeep("jvm-runtime", "khrysalis")
includeDeep("plugin", "khrysalis")
includeDeep("butterfly-android")
includeDeep("butterfly-bluetooth-android")
includeDeep("butterfly-fcm-android")
includeDeep("butterfly-maps-android")
includeDeep("butterfly-qr-android")

//includeSibling("butterfly-ios")
//includeSibling("butterfly-ios-bluetooth")
//includeSibling("butterfly-fcm-ios")
//includeSibling("butterfly-maps-ios")
//includeSibling("butterfly-maps-ios-google")
//includeSibling("butterfly-qr-ios")

//includeSibling("butterfly-web")
//includeSibling("butterfly-fcm-web")
//includeSibling("butterfly-maps-web-google")
//includeSibling("butterfly-maps-web-leaflet")
