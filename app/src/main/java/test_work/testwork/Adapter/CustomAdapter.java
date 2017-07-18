package test_work.testwork.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import me.pinxter.letters.Letters;
import test_work.testwork.Item.ListElement;
import test_work.testwork.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static final int NO_TOPIC = 1;
    private static final int TOPIC = 2;

    private List<ListElement> list_for_element;
    private Context context;
    private Letters letters;

    public CustomAdapter(List<ListElement> list_for_element, Context context, Letters letters) {
        this.list_for_element = list_for_element;
        this.context = context;
        this.letters = letters;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == NO_TOPIC) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element_1, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element_2, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListElement element = list_for_element.get(position);
        holder.textForLetter.setText(letters.getLetter(position));
        holder.img.setBackgroundResource(element.getImg());
        holder.header.setText(element.getHeader());
        holder.date.setText(element.getDate());
        holder.apartments.setText(element.getApartments());
        holder.apartments_build.setText(element.getApartments_build());
        holder.text_body.setText(element.getText_body());
        if (!element.getTopic().equals("")) {
            holder.topic.setText(element.getTopic());
            holder.topic_img.setBackgroundResource(element.getTopic_image());
        }
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "In developing", Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "In developing", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_for_element.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list_for_element.get(position).getId() == NO_TOPIC) {
            return NO_TOPIC;
        } else
            return TOPIC;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView header;
        TextView date;
        TextView apartments;
        TextView apartments_build;
        TextView topic;
        ImageView topic_img;
        TextView text_body;
        CardView cardView;
        TextView textForLetter;
        Button btnMore;
        Button btnRestore;

        public ViewHolder(View itemView) {
            super(itemView);
            textForLetter = (TextView) itemView.findViewById(R.id.text_for_letter);
            img = (ImageView) itemView.findViewById(R.id.image_view);
            header = (TextView) itemView.findViewById(R.id.text_header);
            date = (TextView) itemView.findViewById(R.id.text_date);
            apartments = (TextView) itemView.findViewById(R.id.text_apartments);
            apartments_build = (TextView) itemView.findViewById(R.id.text_apartments_build);
            topic = (TextView) itemView.findViewById(R.id.topic_text);
            topic_img = (ImageView) itemView.findViewById(R.id.topic_img);
            text_body = (TextView) itemView.findViewById(R.id.text_body);
            btnMore = (Button) itemView.findViewById(R.id.btn_more);
            btnRestore = (Button) itemView.findViewById(R.id.btn_restore);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

}
