<template>
    <div>
        <div>
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
                <el-form-item label="ID" prop="id">
                    <el-input v-model="ruleForm.id"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">Query Team ID</el-button>
                </el-form-item>
            </el-form>
        </div>
        <div>
        <el-table
                    ref="table"
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
            </el-table>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    id: '',
                },
                rules: {
                    id: [
                        { required: true, message: 'Enter ID', trigger: 'blur' }
                    ]
                },
                tableData: [],
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this
                        axios.get('http://localhost:8181/teams/findById/' + this.ruleForm.id).then(function (resp) {
                            console.log(resp.data)
                            console.log(_this.tableData)
                            _this.tableData = resp.data
                        })
                    } else {
                        console.log('Error Finding Team');
                        return false;
                    }
                });
            }
        },

        // created() {
        //     const _this = this
        //     axios.get('http://localhost:8181/teams/findById/' + '199f615c8641bcbe98fcc1e688d55f26').then(function (resp) {
                
        //     })
        // }
    }
</script>

<style>
    .form-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 0px auto;
        width: 600px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }

    .login_title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }

    .login_remember {
        margin: 0px 0px 35px 0px;
        text-align: left;
    }
</style>