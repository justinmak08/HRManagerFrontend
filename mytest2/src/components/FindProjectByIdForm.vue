<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleform" label-width="100px" class="form-container">
        <el-form-item label="ID" prop="id">
            <el-input v-model="ruleForm.id"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">Query Project ID</el-button>
            <el-button @click="resetForm('ruleForm')">Clear</el-button>
        </el-form-item>
    </el-form>
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
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.ruleForm.bookCase = {id:this.ruleForm.bookCaseId}
                        const _this = this
                        axios.post('http://localhost:8181/projects/findById',this.ruleForm).then(function (resp) {
                            if(resp.data == 1){
                                _this.$alert('《'+_this.ruleForm.name+'》Project Added!', '', {
                                    confirmButtonText: 'Confirm',
                                    callback: action => {
                                        _this.$router.push("/")
                                    }
                                });
                            }
                        })
                    } else {
                        console.log('Error Finding Project');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
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