package com.geyuxu.studies;

import org.eclipse.jgit.api.Git;

import java.util.UUID;

public class HelloJGit {
    private static RepositoryProvider repoProvider = new RepositoryProviderCloneImpl("git@github.com:geyuxu/studies.git", "/tmp/jgit/j"+ UUID.randomUUID().toString());

    public static void main(String[] args) throws Exception {
        try (Git git = new Git(repoProvider.get())) {
            git.pull().call();
        }
    }
}
