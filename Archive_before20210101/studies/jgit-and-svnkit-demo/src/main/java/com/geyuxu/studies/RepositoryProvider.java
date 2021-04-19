package com.geyuxu.studies;

import org.eclipse.jgit.lib.Repository;

public interface RepositoryProvider {
    Repository get() throws Exception;
}
