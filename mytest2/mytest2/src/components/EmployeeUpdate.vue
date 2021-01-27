<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
        <el-form-item label="First Name" prop="first_name">
            <el-input v-model="ruleForm.first_name"></el-input>
        </el-form-item>
        <el-form-item label="Last Name" prop="last_name">
            <el-input v-model="ruleForm.last_name"></el-input>
        </el-form-item>
        <el-form-item label="Number" prop="number">
            <el-input v-model="ruleForm.number" type="number"></el-input>
        </el-form-item>
        <el-form-item label="Title" prop="title">
            <el-input v-model="ruleForm.title"></el-input>
        </el-form-item>
        <el-form-item label="Accept Date " prop="acceptDate">
            <el-date-picker v-model="ruleForm.acceptDate"></el-date-picker>
        </el-form-item>
        <el-form-item label="Password" prop="password">
            <el-input v-model="ruleForm.password" show-password></el-input>
        </el-form-item>
        <el-form-item label="Email" prop="email">
            <el-input v-model="ruleForm.email" type="email"></el-input>
        </el-form-item>
        <el-form-item label="Phone" prop="phone">
            <el-input type="number" v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="Birthdate" prop="birthdate">
            <el-date-picker v-model="ruleForm.birthdate"></el-date-picker>
        </el-form-item>
        <el-form-item label="Nationality" prop="nationality">
            <el-input v-model="ruleForm.nationality"></el-input>
        </el-form-item>
        <el-form-item label="Salary" prop="salary">
            <el-input type="number" v-model="ruleForm.salary"></el-input>
        </el-form-item>
        <el-form-item label="Skill" prop="skill">
            <el-input v-model="ruleForm.skill"></el-input>
        </el-form-item>
        <el-form-item label="Admin" prop="admin">
            <el-switch
                v-model="ruleForm.admin" 
                active-color="green" 
                inactive-color="red"
                active-value="true"
                inactive-value="false">></el-switch>
        </el-form-item>
        <!-- Have to add automatic id, team_id, creationDate -->
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">Update</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    first_name: '',
                    last_name: '',
                    number:'',
                    title: '',
                    acceptDate: '',
                    password: '',
                    email: '',
                    phone:'',
                    birthdate: '',
                    nationality: '',
                    salary: '',
                    skill: '',
                    admin:'',
                },
                rules: {
                    name: [
                        { required: true, message: 'Enter name', trigger: 'blur' }
                    ],
                    language: [
                        { required: true, message: 'Enter language', trigger: 'blur' }
                    ],
                    startDate: [
                        { required: true, message: 'Enter start date', trigger: 'change' }
                    ],
                    dueDate: [
                        { required: true, message: 'Enter due date', trigger: 'blur' }
                    ],
                    description: [
                        { required: true, message: 'Enter description', trigger: 'blur' }
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
                        axios.put('http://localhost:8181/employee/employeeUpdate',this.ruleForm).then(function (resp) {
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
            axios.get('http://localhost:8181/employee/findById/'+this.$route.query.id).then(function (resp) {
                _this.ruleForm.id = resp.data.id
                _this.ruleForm.first_name = resp.data.first_name
                _this.ruleForm.last_name = resp.data.last_name
                _this.ruleForm.number = resp.data.number
                _this.ruleForm.title = resp.data.title
                _this.ruleForm.acceptDate = resp.data.acceptDate
                _this.ruleForm.password = resp.data.password
                 _this.ruleForm.email = resp.data.email
                _this.ruleForm.phone = resp.data.phone
                _this.ruleForm.birthdate = resp.data.birthdate
                _this.ruleForm.nationality = resp.data.nationality
                _this.ruleForm.salary = resp.data.salary
                _this.ruleForm.skill = resp.data.skill
                _this.ruleForm.admin = resp.data.admin
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