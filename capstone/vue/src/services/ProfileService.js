import axios from 'axios';

export default {

    getProfile(id) {
        return axios.get(`/profile/${id}`, id);
    },

    addProfile(profile) {
        return axios.post(`/profile`, profile);
    },

    editProfile(id, profile) {
        return axios.put(`/profile/${id}`, profile);
    },

    deleteProfile(id) {
        return axios.delete(`/profile/${id}`, id);
    }

}