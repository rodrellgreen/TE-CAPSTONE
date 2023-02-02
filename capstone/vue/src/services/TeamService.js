import axios from 'axios';

export default {

    getUsersTeams() {
        axios.get('/teams')
    },
    getMembersOfTeam(id) {
        axios.get(`/teams/${id}/members`)
    },
    createATeam(team) {
        axios.post('/teams', team)
    },
    addUserToTeam(team) {
        axios.post('/teams/addMember', team)
    },
    getAllAvailableTeams() {
        axios.get('/teams/allTeams')
    },
    updateTeamName(team) {
        axios.put('/teams', team)
    },
    removeUserFromTeam(teamId) {
        axios.delete(`/teams/${teamId}`)
    },
    deleteTeam(teamId) {
        axios.delete(`/teams/remove/${teamId}`)
    }

}