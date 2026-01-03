import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeningListComponent } from './listening-list.component';

describe('ListeningListComponent', () => {
  let component: ListeningListComponent;
  let fixture: ComponentFixture<ListeningListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeningListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeningListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
