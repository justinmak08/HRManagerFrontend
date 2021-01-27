<template>
    <div>
        <div>
            <el-table
                    :data="tableData"
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
                        prop="language"
                        label="language"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="team_id"
                        label="team_id"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="startDate"
                        label="startDate"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="dueDate"
                        label="dueDate"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="creationDate"
                        label="creationDate"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="description"
                        label="description"
                        width="150">
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
                this.$router.push({path:'/projectsUpdate',query:{id:id}})
            },
            change(currentPage) {
                this.currentPage = currentPage
                const _this = this
                axios.get('http://localhost:8181/projects/findByPage/'+currentPage).then(function (resp) {
                    _this.tableData = resp.data.data
                })
            },
            deleteById(row) {
                this.$confirm('Delete《'+row.name+'》?', '提示', {
                    confirmButtonText: 'Delete',
                    cancelButtonText: 'Cancel',
                    type: 'warning'
                }).then(() => {
                    const _this = this
                    axios.delete('http://localhost:8181/projects/deleteById/'+row.id).then(function (resp) {
                        if(resp.data == 1){
                            axios.get('http://localhost:8181/projects/findByPage/'+_this.currentPage).then(function (resp) {
                                // _this.$message({
                                //     type: 'success',
                                //     message: '删除成功!'
                                // });
                                //_this.tableData = resp.data.data

                                _this.$alert('Deleted！', '', {
                                    confirmButtonText: 'Done',
                                    callback: action => {
                                        _this.tableData = resp.data.data
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
                tableData: [],
                currentPage:0
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/projects/findByPage/1').then(function (resp) {
                console.log(resp.data)
                _this.pageSize = resp.data.pageSize
                _this.total = resp.data.total
                _this.tableData = resp.data.data
            })
        }
    }
</script>

<style scoped>

</style>