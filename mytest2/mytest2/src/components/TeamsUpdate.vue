<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
        <el-form-item label="Name" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="Manager" prop="manager">
            <el-input type="number" v-model="ruleForm.manager"></el-input>
        </el-form-item>
        <el-form-item label="Analyst" prop="analyst">
            <el-input type="number" v-model="ruleForm.analyst"></el-input>
        </el-form-item>
        <el-form-item label="Designer" prop="designer">
            <el-input type="number" v-model="ruleForm.designer"></el-input>
        </el-form-item>
        <el-form-item label="Programmer" prop="programmer">
            <el-input type="number" v-model="ruleForm.programmer"></el-input>
        </el-form-item>
        <el-form-item label="Tester" prop="tester">
            <el-input type="number" v-model="ruleForm.tester"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">Add Team</el-button>
            <el-button @click="resetForm('ruleForm')">Clear</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    name: '',
                    manager: '',
                    analyst:'',
                    designer: '',
                    programmer: '',
                    tester:''
                },
                rules: {
                    name: [
                        { required: true, message: 'Enter name', trigger: 'blur' }
                    ],
                    manager: [
                        { required: true, message: 'Enter manager', trigger: 'blur' }
                    ],
                    analyst: [
                        { required: true, message: 'Enter analyst', trigger: 'change' }
                    ],
                    designer: [
                        { required: true, message: 'Enter designer', trigger: 'blur' }
                    ],
                    programmer: [
                        { required: true, message: 'Enter programmer', trigger: 'blur' }
                    ],
                    tester: [
                        { required: true, message: 'Enter tester', trigger: 'change' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log(this.ruleForm)
                        const _this = this
                        //  alert(JSON.stringify(this.ruleForm));
                        // alert(_this);
                        axios.put('http://localhost:8181/teams/teamsUpdate',this.ruleForm).then(function (resp) {
                            if(resp.data == 1){
                                _this.$alert('Updated!', '', {
                                    confirmButtonText: 'Done',
                                    callback: action => {
                                        _this.$router.push("/")
                                    }
                                });
                            }
                        })
                    } else {
                        console.log('Error Updating');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/teams/findById/'+this.$route.query.id).then(function (resp) {
                _this.ruleForm.id = resp.data.id
                _this.ruleForm.name = resp.data.name
                _this.ruleForm.manager = resp.data.manager
                _this.ruleForm.analyst = resp.data.analyst
                _this.ruleForm.designer = resp.data.designer
                _this.ruleForm.programmer = resp.data.programmer
                _this.ruleForm.tester = resp.data.tester
            })
        }
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