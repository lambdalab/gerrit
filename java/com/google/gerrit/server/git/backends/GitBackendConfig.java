package com.google.gerrit.server.git.backends;

import com.google.gerrit.server.config.GerritServerConfig;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.jgit.lib.Config;

@Singleton
public class GitBackendConfig {

  static final String GIT_SECTION_NAME = "git";
  static final String TYPE_NAME = "type";
  static final String MANAGER_CLASS_NAME = "managerClass";
  static final GitBackendType DEFAULT_TYPE = GitBackendType.FILE;
  private Config cfg;

  @Inject
  public GitBackendConfig(@GerritServerConfig Config cfg) {
    this.cfg = cfg;
  }

  public GitBackendType getBackendType() {
    return cfg.getEnum(GIT_SECTION_NAME, null, TYPE_NAME, DEFAULT_TYPE);
  }

  public String managerClass(){
    return cfg.getString(GIT_SECTION_NAME, null, MANAGER_CLASS_NAME);
  }

  public String getString(String name) {
    return cfg.getString(GIT_SECTION_NAME, null, name);
  }
  public int getInt(String name, int defaultValue) {
    return cfg.getInt(GIT_SECTION_NAME, null, name, defaultValue);
  }
}
