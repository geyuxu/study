//package com.geyuxu.studies;
//
//import org.eclipse.jgit.api.Git;
//import org.eclipse.jgit.lib.Constants;
//import org.eclipse.jgit.lib.Ref;
//import org.eclipse.jgit.lib.Repository;
//import org.eclipse.jgit.revwalk.DepthWalk;
//import org.eclipse.jgit.revwalk.RevCommit;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//
//public class HelloJGit3 {
//    private static RepositoryProvider repoProvider = new RepositoryProviderExistingClientImpl("/tmp/jgit/j3495f09e-67ad-466c-8982-df9695354218/.git");
//
//    public static void main(String[] args) throws Exception {
//        try (Repository repo = repoProvider.get()) {
//            Ref ref = repo.getAllRefs().get(Constants.HEAD);
//            try (DepthWalk.RevWalk revWalk = new DepthWalk.RevWalk(repo)) {
//                RevCommit lastCommit = revWalk.parseCommit(ref.getObjectId());
//                revWalk.markStart(lastCommit);
//                revWalk.forEach(System.out::println);
//            }
//        }
//    }
//
//    private static void createFileFromGitRoot(Repository repo, String filename, String content) throws FileNotFoundException {
//        File hello3 = new File(repo.getDirectory().getParent(), filename);
//        try (PrintWriter out = new PrintWriter(hello3)) {
//            out.println(content);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
