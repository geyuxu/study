package com.geyuxu.studies;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HelloJGit2 {
    private static RepositoryProvider repoProvider = new RepositoryProviderExistingClientImpl("/tmp/jgit/j3495f09e-67ad-466c-8982-df9695354218/.git");

    public static void main(String[] args) throws Exception {
        try (Repository repo = repoProvider.get();
             Git git = new Git(repo)) {
            createFileFromGitRoot(repo, "hello3.txt", "hello3");
            git.add()
                    .addFilepattern("hello3.txt")
                    .call();
            git.commit()
                    .setMessage("hello3-2")
                    .call();
            git.push()
                    .setRemote("origin")
                    .call();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void createFileFromGitRoot(Repository repo, String filename, String content) throws FileNotFoundException {
        File hello3 = new File(repo.getDirectory().getParent(), filename);
        try (PrintWriter out = new PrintWriter(hello3)) {
            out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
