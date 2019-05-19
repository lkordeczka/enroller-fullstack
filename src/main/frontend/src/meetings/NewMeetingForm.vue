<template>
  <div>
    <form @submit.prevent="addNewMeeting($event)" v-if="adding">
      <h3>Dodaj nowe spotkanie</h3>
      <label>Nazwa</label>
      <input type="text" v-model="newMeeting.name">
      <label>Opis</label>
      <textarea v-model="newMeeting.description"></textarea>
      <button>Dodaj</button>
      <span class="error" v-if="error">Spotkanie musi mieć nazwę!</span>
    </form>
    <button @click="adding = true" v-else>Dodaj nowe spotkanie</button>
  </div>
</template>

<script>
    export default {
        data() {
            return {
                newMeeting: {participants: []},
                adding: false,
                error: false
            };
        },
        methods: {
            addNewMeeting(meeting) {
                this.error = false;
                if (this.newMeeting.name) {
                    this.$http.post('meetings', {"title": this.newMeeting.name, 'description': this.newMeeting.description})
                    this.$emit('added', this.newMeeting);
                    this.newMeeting = {participants: []};
                    this.adding = false;
                } else {
                    this.error = true;
                }
            }
        }
    }
</script>

<style scoped>
  .error {
    color: #F00;
  }
</style>
