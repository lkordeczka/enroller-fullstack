<template>
  <form @submit.prevent="enter()">
    <H2>Formularz {{ HeaderName }}</H2>
    <label>Login</label>
    <input type="text" v-model="user.login">
    <label>Hasło</label>
    <input type="password" v-model="user.password">
    <button type="submit">{{ labelOfTheButton }}</button>
  </form>
</template>

<script>
    export default {
        props: ["buttonLabel", "h2Label"],
        data() {
            return {
                user: {}
            };
        },
        methods: {
            enter() {
                this.$emit("login", this.user);
            }
        },
        computed: {
            labelOfTheButton() {
                return this.buttonLabel || 'zaloguj się';
            },
            HeaderName() {
                return this.h2Label || 'logowania';
            }
        }
    };
</script>
