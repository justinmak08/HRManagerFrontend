<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="form-container">
        <el-form-item label="Name" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="Language" prop="language">
            <el-select v-model="ruleForm.language" placeholder="Select">
                <el-option 
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="Start Date" prop="startDate">
            <el-date-picker v-model="ruleForm.startDate"></el-date-picker>
        </el-form-item>
        <el-form-item label="Due Date" prop="dueDate">
            <el-date-picker v-model="ruleForm.dueDate"></el-date-picker>
        </el-form-item>
        <el-form-item label="Description" prop="description">
            <el-input v-model="ruleForm.description"></el-input>
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
                    name: '',
                    language: '',
                    startDate:'',
                    dueDate: '',
                    description: ''
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
                },
                options: [{
                    value: 'chinese',
                    label: 'Chinese'
                }, {
                    value: 'english',
                    label: 'English'
                }, {
                    value: 'hindi',
                    label: 'Hindi'
                }, {
                    value: 'spanish',
                    label: 'Spanish'
                }, {
                    value: 'french',
                    label: 'French'
                }, {
                    value: 'arabic',
                    label: 'Arabic'
                }, {
                    value: 'bangali',
                    label: 'Bengali'
                }, {
                    value: 'russian',
                    label: "Russian"
                }],
                value: ''
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this
                        axios.put('http://localhost:8181/projects/projectsUpdate',this.ruleForm).then(function (resp) {
                            if(resp.data == 1){
                                _this.$alert('《'+_this.ruleForm.name+'Updated!', '', {
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
            axios.get('http://localhost:8181/projects/findById/'+this.$route.query.id).then(function (resp) {
                _this.ruleForm.id = resp.data.id
                _this.ruleForm.name = resp.data.name
                _this.ruleForm.language = resp.data.language
                _this.ruleForm.startDate = resp.data.startDate
                _this.ruleForm.dueDate = resp.data.dueDate
                _this.ruleForm.description = resp.data.description
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