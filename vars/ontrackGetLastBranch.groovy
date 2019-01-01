import net.nemerosa.ontrack.jenkins.pipeline.ParamUtils

def call(Map<String,?> params) {
   String project = ParamUtils.getParam(params, "project")
   String pattern = ParamUtils.getParam(params, "pattern", ".*")

   def result = ontrackGraphQL(
      script: '''
         query BranchLookup($project: String!, $pattern: String!) {
            branches(project: $project, name: $pattern) {
               name
            }
         }
      ''',
      bindings: [
         project: project,
         pattern: pattern
      ]
   )

   def branches = result.data.branches
   if (branches.isEmpty()) {
      return null
   } else {
      return branches.first().name.asText()
   }
}
