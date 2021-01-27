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
                        prop="number"
                        label="number"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="acceptDate"
                        label="acceptDate"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="title"
                        label="title"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="first_name"
                        label="first_name"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="last_name"
                        label="last_name"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="email"
                        label="email"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="password"
                        label="password"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="phone"
                        label="phone"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="birthdate"
                        label="birthdate"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="nationality"
                        label="nationality"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="salary"
                        label="salary"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="accounting"
                        label="accounting"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="skill"
                        label="skill"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="admin"
                        label="admin"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="logged"
                        label="logged"
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
                this.$router.push({path:'/employeeUpdate',query:{id:id}})
            },
            change(currentPage) {
                this.currentPage = currentPage
                const _this = this
                axios.get('http://localhost:8181/employee/findByPage/'+currentPage).then(function (resp) {
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
                    axios.delete('http://localhost:8181/employee/deleteById/'+row.id).then(function (resp) {
                        console.log(row.id)
                        if(resp.data == 1){
                            axios.get('http://localhost:8181/employee/findByPage/'+_this.currentPage).then(function (resp) {
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
            axios.get('http://localhost:8181/employee/findByPage/1').then(function (resp) {
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