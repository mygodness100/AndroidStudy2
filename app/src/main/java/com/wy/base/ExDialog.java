package com.wy.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 点击弹出提示框
 */
@ContentView(R.layout.activity_ex_dialog)
public class ExDialog extends AppCompatActivity {


    private static final String TAG = "ACTIVITY_EX_DIALOG";
    @ViewInject(R.id.button)
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    /**
     * 点击弹出2键提示框
     *
     * @param view
     */
    @Event(value = R.id.button)
    private void click2(View view) {
        AlertDialog alert2 = new AlertDialog.Builder(ExDialog.this)
                .setCancelable(false)//默认点击页面其他地方不能取消对话框
                .setIcon(R.drawable.test01)
                .setTitle("两键按钮")
                .setMessage("你到底是想干什么呢,啊啊, 啊啊,啊,啊")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //操作
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //操作
                    }
                }).create();
        // 布局填充函数,将其他的布局嵌入到当前view中
//        LayoutInflater inflater = getLayoutInflater();
//        // 获得需要填充到当前view中的子组件
//        View inflate = inflater.inflate(R.layout.activity_action_bar, null);
//        // 将自定义的布局填充到父组件中
//        alert2.setView(inflate);
        alert2.show();
    }

    /**
     * 点击弹出3键提示框
     *
     * @param view
     */
    @Event(value = R.id.button)
    private void click3(View view) {
        AlertDialog alert3 = new AlertDialog.Builder(ExDialog.this)
                .setIcon(R.drawable.test01)
                .setTitle("两键按钮")
                .setMessage("你到底是想干什么呢,啊啊, 啊啊,啊,啊")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //左键操作
                    }
                })
                .setNeutralButton("不知道", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //中间操作
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //右键操作
                    }
                }).create();
        alert3.show();
    }

    /**
     * 点击弹出列表提示框,没有确定,取消这些按钮,只有选项,点击后自动完成事件,只能选一个
     * SetItem和SetMessage只能选一个
     * setItem第一个参数是数据来源,可以是资源问价,也可以是传进来的值
     * 第二个参数是点击每一个选项时候的事件
     *
     * @param view
     */
    @Event(value = R.id.button)
    private void clickItem(View view) {
        new AlertDialog.Builder(ExDialog.this)
                .setIcon(R.drawable.test01)
                .setTitle("列表提示")
                .setItems(R.array.dialogItem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //从资源文件中取出相应资源
                        String[] array = getResources().getStringArray(R.array.dialogItem);
                        Log.d(TAG, array[which]);
                        //也可以在弹出一个提示框的时候再弹出一个

                        new AlertDialog.Builder(ExDialog.this).setIcon(R.drawable.test01)
                                .setMessage("再弹出一个提示框")
                                .show();
                        Toast.makeText(ExDialog.this, "自动小时提示框", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    /**
     * 弹出单选提示框,有多个选项,但是只能选一个,而且选择之后还需要选择确定或取消完成事件
     * 第一个参数是数据来源
     * 第二个参数是默认选中第几个选项
     * 第三个参数是点击每个选项触发的事件
     *
     * @param view
     */
    @Event(value = R.id.button)
    private void clickSingle(View view) {
        new AlertDialog.Builder(ExDialog.this)
                .setIcon(R.drawable.test01)
                .setTitle("列表提示")
                .setSingleChoiceItems(R.array.dialogItem, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNeutralButton("不知道", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
                .show();
    }

    /**
     * 弹出复选框,有多个选项,可选择多个,而且选择之后还需要选择确定或取消完成事件
     * 第一个参数是数据来源
     * 第二个参数是boolean数组,决定那个是选中,那个是不选中
     * 第三个参数是点击每个选项触发的事件
     *
     * @param view
     */
    @Event(value = R.id.button)
    private void clickMulti(View view) {
        new AlertDialog.Builder(ExDialog.this)
                .setIcon(R.drawable.test01)
                .setTitle("列表提示")
                .setMultiChoiceItems(R.array.dialogItem, new boolean[]{false, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNeutralButton("不知道", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }

    /**
     * 点击的时候弹出一个可以输入文字的对话框
     * @param view
     */
    @Event(R.id.button)
    private void clickPop(View view){
        // 布局管理器
        LayoutInflater li = LayoutInflater.from(ExDialog.this);
        // 得到需要弹出的自定义布局文件
        // 如果自定义个布局文件中有需要得到的数据,不能直接用findById,需要带上popDialogView
        final View popDialogView = li.inflate(R.layout.activity_ex_dialog,null);
        AlertDialog ad = new AlertDialog.Builder(ExDialog.this).setTitle("this is a test")
                .setView(popDialogView).setPositiveButton("OK",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //处理事件
                    }
                }).setNegativeButton("cancel",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //处理事件
                    }
                }).show();
    }

    /**
     * 自定义一个带图片和文字的toast
     * @param view
     */
    @Event(R.id.button)
    private void clickToast(View view){
        // 布局管理器
        LayoutInflater li = getLayoutInflater();
        // 得到需要弹出的自定义布局文件
        // 如果自定义个布局文件中有需要得到的数据,不能直接用findById,需要带上popDialogView
        // 要将布局文件中的组件转变为ViewGroup,以便调用
        final View popDialogView = li.inflate(R.layout.activity_dialog_pop,(ViewGroup) findViewById(R.id.activity_dialog_pop));
        ImageView username = (ImageView) popDialogView.findViewById(R.id.username);
        EditText password = (EditText)popDialogView.findViewById(R.id.password);
        username.setImageResource(R.drawable.test01);
        password.setText("this is a test");
        Toast toast = new Toast(getApplicationContext());
        toast.setView(popDialogView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 自定义一个列表
     */
    public void custom(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] items = new String[]{"测试1","测试2","测试4"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ExDialog.this,items[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
