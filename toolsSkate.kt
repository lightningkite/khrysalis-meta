@file:DependsOn("org.kohsuke:github-api:1.116")
@file:DependsOn("org.eclipse.jgit:org.eclipse.jgit:5.9.0.202009080501-r")

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.URIish
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import org.kohsuke.github.GitHub
import java.io.File

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

    for(folder in butterflyFolders){
        println("git submodule add https://github.com/lightningkite/${folder.name}.git ${folder.name}")
    }

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