<template>
  <div>
    <h1>Team</h1>
    <h3>{{ team.teamName }}</h3>
    <h2>Members</h2>
    <ul>
      <li v-for="member in members" :key="member.id">
        {{ member }}
      </li>
    </ul>
    <h2>Team Message Board</h2>
    <form @submit.prevent="addPost(post)">
      <div>
        <label>Make a Post: </label>
        <textarea v-model="post.message"></textarea>
      </div>
      <button type="submit">Submit</button>
    </form>
    <h2>Team Posts</h2>
    <div v-for="post in teamPosts" :key="post.postId">
      <h2>Author: {{ post.displayName }}</h2>
      <p>Message: {{ post.message }}</p>
    </div>
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
</style>