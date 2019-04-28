<template>
    <div>
        <b-container>
            <b-button id="show-btn" @click="showModal">Add</b-button>
            <b-row class="bg-info">
                <b-col>#</b-col>
                <b-col>First Name</b-col>
                <b-col>Last Name</b-col>
                <b-col>Age</b-col>
                <b-col>Email</b-col>
            </b-row>
            <b-row v-for="member in members" :key="member.memberSeq">
                <b-col>{{member.memberSeq}}</b-col>
                <b-col>{{member.firstName}}</b-col>
                <b-col>{{member.lastName}}</b-col>
                <b-col>{{member.age}}</b-col>
                <b-col>{{member.email}}</b-col>
            </b-row>
        </b-container>
        <b-modal ref="add-modal" hide-footer title="Add new member">
            <div class="d-block text-center">
                <b-input-group prepend="first name" class="mt-3">
                    <b-form-input v-model="newMember.firstName"></b-form-input>
                </b-input-group>
                <b-input-group prepend="last mame" class="mt-3">
                    <b-form-input v-model="newMember.lastName"></b-form-input>
                </b-input-group>
                <b-input-group prepend="age" class="mt-3">
                    <b-form-input v-model="newMember.age"></b-form-input>
                </b-input-group>
                <b-input-group prepend="email" class="mt-3">
                    <b-form-input v-model="newMember.email"></b-form-input>
                </b-input-group>
            </div>
            <b-button class="mt-3" variant="primary" block @click="addMember">Done</b-button>
            <b-button class="mt-3" variant="outline-danger" block @click="hideModal">Cancel</b-button>
        </b-modal>
    </div>
</template>

<script>
import api from '../Api'

export default {
    name: 'Member',
    data:function() {
        return {
            newMember: {},
            members: []
        }
    },
    mounted() {
        api.getMembers()
        .then(response => {
            this.members = response.data
        }).catch(error => {
            
        })
    },
    methods: {
        showModal() {
            this.$refs['add-modal'].show()
        },
        hideModal() {
            this.$refs['add-modal'].hide()
            this.newMember = {}
        },
        addMember() {
            console.log('new: ',this.newMember)
            this.newMember = {}
            this.$refs['add-modal'].hide()
        },
        removeMember() {

        },
        updateMember() {
            
        }
    }
}
</script>
<style>

</style>