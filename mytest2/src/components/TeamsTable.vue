<template>
    <div>
        <div>
            <el-table
                    :data="teamsTableData"
                    border
                    style="width: 80%;margin-left: 100px;margin-top: 30px;">
                <el-table-column
                        fixed
                        prop="id"
                        label="id"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="name"
                        label="name"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="manager"
                        label="manager"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="analyst"
                        label="analyst"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="designer"
                        label="designer"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="tester"
                        label="tester"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="programmer"
                        label="programmer"
                        width="120">
                </el-table-column>
                <el-table-column
                        fixed="right"
                        label=""
                        width="100">
                    <template slot-scope="scope">
                        <el-button @click="findById(scope.row.id)" type="text" size="small">Edit</el-button>
                        <el-button @click="deleteById(scope.row)" type="text" size="small">Delete</el-button>
                    </template>
                </el-table-column>

            </el-table>
            <el-pagination
                    background
                    layout="prev, pager, next"
                    :total="total"
                    :page-size="pageSize"
                    @current-change="change"
            >
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        methods: {
            findById(id) {
                this.$router.push({path:'/teamsUpdate',query:{id:id}})
            },
            change(currentPage) {
                this.currentPage = currentPage
                const _this = this
                axios.get('http://localhost:8181/teams/findByPage/'+currentPage).then(function (resp) {
                    _this.teamsTableData = resp.data.data
                })
            },
            deleteById(row) {
                this.$confirm('Delete《'+row.name+'》?', '提示', {
                    confirmButtonText: 'Delete',
                    cancelButtonText: 'Cancel',
                    type: 'warning'
                }).then(() => {
                    const _this = this
                    axios.delete('http://localhost:8181/teams/deleteById/'+row.id).then(function (resp) {
                        if(resp.data == 1){
                            axios.get('http://localhost:8181/teams/findByPage/'+_this.currentPage).then(function (resp) {
                                // _this.$message({
                                //     type: 'success',
                                //     message: '删除成功!'
                                // });
                                //_this.teamsTableData = resp.data.data

                                _this.$alert('Deleted！', '', {
                                    confirmButtonText: 'Done',
                                    callback: action => {
                                        _this.teamsTableData = resp.data.data
                                    }
                                });

                            })
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: 'Delete cancelled'
                    });
                });
            }
        },

        data() {
            return {
                total:0,
                pageSize:5,
                teamsTableData: [],
                currentPage:0
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/teams/findByPage/1').then(function (resp) {
                console.log(resp.data)
                _this.pageSize = resp.data.pageSize
                _this.total = resp.data.total
                _this.teamsTableData = resp.data.data
            })
        }
    }
</script>

<style scoped>

</style>