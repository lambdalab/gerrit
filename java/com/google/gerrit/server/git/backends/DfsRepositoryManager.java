package com.google.gerrit.server.git.backends;

import com.google.gerrit.extensions.events.LifecycleListener;
import com.google.gerrit.lifecycle.LifecycleModule;
import com.google.gerrit.server.git.GitRepositoryManager;
import com.google.inject.Inject;

public abstract class DfsRepositoryManager implements GitRepositoryManager {

  public static class Module extends LifecycleModule {
    private GitBackendConfig config;

    public Module(GitBackendConfig config) {
      this.config = config;
    }

    @Override
    protected void configure() {
      String className = config.managerClass();
      try {
        Class moduleClass = Class.forName(className);
        bind(GitRepositoryManager.class).to(moduleClass);
        listener().to(DfsRepositoryManager.Lifecycle.class);
      } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException("Module class " + className + " not found.");
      }
    }
  }

  public static class Lifecycle implements LifecycleListener {

    private DfsRepositoryManager repositoryManager;

    @Inject
    public Lifecycle(GitRepositoryManager repositoryManager) {
      this.repositoryManager = (DfsRepositoryManager) repositoryManager;
    }

    @Override
    public void start() {
      repositoryManager.start();
    }

    @Override
    public void stop() {
      repositoryManager.stop();
    }
  }

  public abstract void stop();

  public abstract void start();
}
