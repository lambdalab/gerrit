import org.eclipse.jgit.lib.ObjectId;
      "\n" +
      "diff --git a/a.txt b/a.txt\n" +
      "new file mode 100644\n" +
      "index 0000000..f0eec86\n" +
      "--- /dev/null\n" +
      "+++ b/a.txt\n" +
      "@@ -0,0 +1 @@\n" +
      "+some content\n" +
      "\\ No newline at end of file\n";
  private final String fileName;
  private final String content;
    this.fileName = fileName;
    this.content = content;
      .committer(new PersonIdent(i, testRepo.getClock()));
    commitBuilder.add(fileName, content);
    commitBuilder.rm(fileName);
    return new Result(ref, pushHead(testRepo, ref, tag != null, force), c,
        subject);
    public ObjectId getCommitId() {
    public RevCommit getCommit() {
      return commit;
        throws OrmException {
        throws OrmException {
      Iterable<Account.Id> actualIds =
          approvalsUtil.getReviewers(db, notesFactory.create(c)).values();
        .named(message(refUpdate))