<template>
    <div>
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <Date
            label="RegistrationDate"
            v-model="value.registrationDate"
            :editMode="editMode"
        />
        <Date
            label="PublicationDate"
            v-model="value.publicationDate"
            :editMode="editMode"
        />
        <Number
            label="NumberOfSubscribers"
            v-model="value.numberOfSubscribers"
            :editMode="editMode"
        />
        <String
            label="publicationID"
            v-model="value.publicationId"
            :editMode="editMode"
        />
        <Number
            label="manuscriptID"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <Number
            label="authorID"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Book',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "books",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
