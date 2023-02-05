<template>
  <div>
    <v-container>
      <v-row>
        <v-col class="d-flex flex-column" cols="3">
          <h2 id="teamName">{{ team.teamName }}</h2>

          <h3 id="membersTitle">Members</h3>
          <v-list id="membersNames">
            <v-list-item v-for="member in members" :key="member.id">
              {{ member }}
            </v-list-item>
          </v-list>
        </v-col>
      </v-row>
    </v-container>
    <v-container class="d-flex flex-wrap justify-center">
      <v-card v-for="post in teamPosts" :key="post.postId" class="posts">
        <v-card-title id="posterName">{{ post.displayName }}</v-card-title>
        <v-card-text id="posterMessage">{{ post.message }}</v-card-text>
      </v-card>
    </v-container>

    <v-card-actions>
      <v-container class="d-flex flex-wrap justify-center">
        <v-textarea
          v-model="post.message"
          label="Post A Message"
          auto-grow
          row="2"
          class="postArea"
        ></v-textarea>
      </v-container>
      <v-btn @click="addPost(post)">Post</v-btn>
    </v-card-actions>
  </div>
</template>

<script>
import teamService from "../services/TeamService.js";
import postService from "../services/PostService.js";
export default {
  data() {
    return {
      team: {},
      members: [],
      teamId: this.$route.params.teamIndex,
      post: {
        teamId: Number.parseInt(this.$route.params.teamIndex),
        message: "",
      },
      teamPosts: [],
    };
  },
  created() {
    teamService.getSpecificTeam(this.teamId).then((response) => {
      this.team = response.data;
    });
    teamService.getMembersOfTeam(this.teamId).then((response) => {
      this.members = response.data;
    });
    postService.getAllPostsForTeam(this.teamId).then((response) => {
      this.teamPosts = response.data;
    });
  },
  methods: {
    addPost(post) {
      postService.createPost(post).then((response) => {
        if (response.status == 201) {
          postService.getAllPostsForTeam(this.teamId).then((response) => {
            this.teamPosts = response.data;
            this.post = {};
          });
        }
      });
    },
  },
};
</script>

<style>
.postArea {
  width: 70vw;
  height: 500px;
  padding-left: 10vw;
}
.posts {
  border: 1px solid rgba(0, 0, 0, 0.12);
  width: 70vw;
}
</style>