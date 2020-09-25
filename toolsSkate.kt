@file:DependsOn("org.kohsuke:github-api:1.116")
@file:DependsOn("org.eclipse.jgit:org.eclipse.jgit:5.9.0.202009080501-r")

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.URIish
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import org.kohsuke.github.GitHub
import java.io.File
import kotlin.math.min

val github = GitHub.connect()
val githubToken = File(System.getProperty("user.home")).resolve(".github").readText().substringAfter('=')
val gitCredentials = UsernamePasswordCredentialsProvider(github.myself.login, githubToken)

fun main() {
    println("Using token $githubToken")

    val metaFolder = File("/home/joseph/IdeaProjects/khrysalis-meta")
    val allFiles = metaFolder.listFiles()?.toList() ?: listOf()
    val butterflyFolders = allFiles.filter { it.isDirectory && it.name.contains("butterfly") }
    println(butterflyFolders.joinToString("\n") { it.name })

    val lkOrg = github.myOrganizations["lightningkite"]!!
    val lkTeam = github.myTeams["lightningkite"]!!.find { it.name.contains("develop", true) }!!

    butterflyFolders
            .filter { it.name.contains("android", true) }
            .forEach {
                it.walkBottomUp()
                        .filter { it.name.endsWith(".shared.kt") }
                        .forEach {
                            it.writeText("//! This file is Khrysalis compatible.\n" + it.readText())
                            it.renameTo(it.parentFile.resolve(it.name.replace(".shared", "")))
                        }
            }

//    for(folder in butterflyFolders){
//        folder.walkBottomUp().filter { !it.path.contains("/.") && !it.path.contains("Pods/") }.forEach {
//            if(it.name.contains(".gradle")) return@forEach
//            if(it.name.contains(".class")) return@forEach
//            if(it.name.contains(".json")) return@forEach
//            if(it.isFile) {
//                val text = it.readText()
//                println("Will run replacements in ${it.relativeTo(metaFolder)} ")
//                it.writeText(it.readText()
//                        .replace("khrysalis", "butterfly")
//                        .replace("Khrysalis", "Butterfly")
//                        .replace("KHRYSALIS", "BUTTERFLY"))
//            }
//            if(it.name.contains("khrysalis", true)) {
//                val newName = it.name
//                        .replace("khrysalis", "butterfly")
//                        .replace("Khrysalis", "Butterfly")
//                        .replace("KHRYSALIS", "BUTTERFLY")
//                println("Will rename ${it.relativeTo(metaFolder)} to ${it.parentFile.resolve(newName).relativeTo(metaFolder)}")
//                it.renameTo(it.parentFile.resolve(newName))
//            }
//        }
//    }

//    for (folder in butterflyFolders) {
//        folder.resolve(".gitignore").writeText("""
//local.properties
//**/build
//**/Pods
//*.xcworkspace
//**/xcuserdata
//**.iml
//**.iws
//**/.idea
//**/.gradle
//*.apk
//*.class
//**/node_modules
//""")
//        val repo = try {
//            Git.open(folder)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Git.init()
//                    .setDirectory(folder)
//                    .call()
//        }
//        if (repo.add()
//                        .addFilepattern(".")
//                        .call()
//                        .entryCount > 0) {
//            repo.commit()
//                    .setMessage("Initial commit")
//                    .setAuthor("Joseph Ivie", "joseph@lightningkite.com")
//                    .call()
//        }
//        val gh = try {
//            github.getRepository(lkOrg.login + "/" + folder.name)
//        } catch (e: Exception) {
//            lkOrg.createRepository(folder.name)
//                    .team(lkTeam)
//                    .private_(false)
//                    .create()
//        }
//        if(repo.remoteList().call().none { it.name == "origin" }){
//            repo.remoteAdd()
//                    .setName("origin")
//                    .setUri(URIish(gh.httpTransportUrl))
//                    .call()
//        }
//        repo.push()
//                .setCredentialsProvider(gitCredentials)
//                .call()
//    }
}